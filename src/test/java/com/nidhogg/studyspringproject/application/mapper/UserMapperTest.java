package com.nidhogg.studyspringproject.application.mapper;

import com.nidhogg.studyspringproject.domain.model.user.Role;
import com.nidhogg.studyspringproject.domain.model.user.User;
import com.nidhogg.studyspringproject.dto.user.UserDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class UserMapperTest {

    private final UserMapper userMapper = new UserMapper();

    @Test
    void shouldReturnFilledUserDto_whenToDto_givenFilledUser() {
        // given
        User givenUser = new User();
        givenUser.setId(1L);
        givenUser.setEmail("test@gmail.com");
        givenUser.setPassword("123qwe");
        givenUser.setRole(Role.USER);

        UserDto expectedUserDto = new UserDto();
        expectedUserDto.setEmail("test@gmail.com");
        expectedUserDto.setPassword("123qwe");
        expectedUserDto.setRole(Role.USER);

        // when
        UserDto actualUserDto = userMapper.toDto(givenUser);

        // then
        assertThat(actualUserDto).isEqualToComparingFieldByField(expectedUserDto);
    }
}