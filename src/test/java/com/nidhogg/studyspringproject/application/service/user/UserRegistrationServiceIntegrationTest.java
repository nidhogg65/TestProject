package com.nidhogg.studyspringproject.application.service.user;

import com.nidhogg.studyspringproject.application.dto.user.RegistrationUserDto;
import com.nidhogg.studyspringproject.application.dto.user.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static com.nidhogg.studyspringproject.domain.model.user.Role.USER;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, properties = "spring.h2.console.enabled=true")
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
class UserRegistrationServiceIntegrationTest {

    private static final String DEFAULT_EMAIL = "test@test.com";
    private static final String DEFAULT_PASSWORD = "1q2w3e";

    @Autowired
    private UserRegistrationService service;

    @Test
    void shouldReturnNewUserDto_whenRegisterNewUser_givenRegistrationUserDtoWithNotExistingEmail() {
        // given
        RegistrationUserDto givenUser = new RegistrationUserDto(DEFAULT_EMAIL, DEFAULT_PASSWORD, USER);

        // when
        UserDto actualRegisteredUserDto = service.registerNewUser(givenUser);

        // then
        assertThat(actualRegisteredUserDto).isNotNull();
    }
}