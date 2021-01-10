package com.nidhogg.studyspringproject.dto.user;

import com.nidhogg.studyspringproject.domain.model.user.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class RegistrationUserDto {

    @Email
    @NotNull
    private String email;

    @NotBlank
    private String password;

    @NotNull
    private Role role;

}
