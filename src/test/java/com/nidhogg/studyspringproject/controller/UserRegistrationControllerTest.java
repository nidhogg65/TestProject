package com.nidhogg.studyspringproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nidhogg.studyspringproject.application.dto.user.RegistrationUserDto;
import com.nidhogg.studyspringproject.application.dto.user.UserDto;
import com.nidhogg.studyspringproject.application.service.user.UserRegistrationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.nidhogg.studyspringproject.domain.model.user.Role.USER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserRegistrationController.class)
class UserRegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserRegistrationService registrationService;

    @Test
    void shouldReturn201_whenUsersPostRequest_givenValidRegistrationUserDto() throws Exception {
        // given
        RegistrationUserDto givenUser = new RegistrationUserDto("test@test.com", "1q2w3e", USER);

        // when
        mockMvc.perform(MockMvcRequestBuilders.post("/rest/api/v1/users")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(givenUser)))

                //then
                .andExpect(status().isCreated());
    }

    @Test
    void shouldReturnUserDto_whenUsersPostRequest_givenValidRegistrationUserDto() throws Exception {
        // given
        RegistrationUserDto givenUser = new RegistrationUserDto("test@test.com", "1q2w3e", USER);
        UserDto expectedResult = new UserDto(1L, "test@test.com", "1q2w3e", USER);
        given(registrationService.registerNewUser(refEq(givenUser))).willReturn(expectedResult);

        // when
        MvcResult actualResult = mockMvc.perform(MockMvcRequestBuilders.post("/rest/api/v1/users")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(givenUser))).andReturn();
        String actualResultAsString = actualResult.getResponse().getContentAsString();

        // then
        assertThat(actualResultAsString).isEqualTo(objectMapper.writeValueAsString(expectedResult));
    }
}