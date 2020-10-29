package com.nidhogg.studyspringproject.application.service.user;

import com.nidhogg.studyspringproject.application.dto.user.RegistrationUserDto;
import com.nidhogg.studyspringproject.application.dto.user.UserDto;
import com.nidhogg.studyspringproject.application.exception.EmailExistsException;
import com.nidhogg.studyspringproject.application.mapper.user.UserMapper;
import com.nidhogg.studyspringproject.domain.model.user.User;
import com.nidhogg.studyspringproject.domain.repository.user.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.nidhogg.studyspringproject.domain.model.user.Role.USER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RegistrationUserServiceTest {

    private static final String DEFAULT_EMAIL = "test@test.com";
    private static final String DEFAULT_PASSWORD = "1q2w3e";

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private RegistrationUserService service;

    @Test
    void shouldReturnNewUserDto_whenRegisterNewUser_givenRegistrationUserDtoWithNotExistingEmail() {
        // given
        RegistrationUserDto givenUser = new RegistrationUserDto(DEFAULT_EMAIL, DEFAULT_PASSWORD, USER);

        when(userRepository.existsUserByEmail(DEFAULT_EMAIL)).thenReturn(false);
        when(userRepository.save(any(User.class))).thenReturn(provideCreatedUser());
        when(passwordEncoder.encode(DEFAULT_PASSWORD)).thenReturn(DEFAULT_PASSWORD);
        when(userMapper.toDto(any(User.class))).thenReturn(provideCreatedUserDto());

        // when
        UserDto actualRegisteredUserDto = service.registerNewUser(givenUser);

        // then
        assertThat(actualRegisteredUserDto).isEqualToComparingFieldByField(provideCreatedUserDto());
    }

    @Test
    void shouldThrowEmailExistsException_whenRegisterNewUser_givenRegistrationUserDtoWithAlreadyExistingEmail() {
        // given
        RegistrationUserDto givenUser = new RegistrationUserDto(DEFAULT_EMAIL, DEFAULT_PASSWORD, USER);

        when(userRepository.existsUserByEmail(DEFAULT_EMAIL)).thenReturn(true);

        // when
        EmailExistsException actualException = assertThrows(EmailExistsException.class,
                () -> service.registerNewUser(givenUser));

        // then
        verify(passwordEncoder, never()).encode(any());
        verify(userRepository, never()).save(any());
        verify(userMapper, never()).toDto(any());

        assertThat(actualException).isNotNull();
    }

    private User provideCreatedUser() {
        User user = new User();
        user.setId(1L);
        user.setEmail(DEFAULT_EMAIL);
        user.setPassword(DEFAULT_PASSWORD);
        user.setRole(USER);
        return user;
    }

    private UserDto provideCreatedUserDto() {
        UserDto user = new UserDto();
        user.setId(1L);
        user.setEmail(DEFAULT_EMAIL);
        user.setPassword(DEFAULT_PASSWORD);
        user.setRole(USER);
        return user;
    }
}