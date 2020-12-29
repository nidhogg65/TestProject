package com.nidhogg.studyspringproject.dto.user;

import com.nidhogg.studyspringproject.domain.model.user.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RegistrationUserDto {

    @Email
    private String email;

    @NotBlank
    private String password;

    @NotNull
    private Role role;

    public RegistrationUserDto() {
    }

    public RegistrationUserDto(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "RegistrationUserDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
