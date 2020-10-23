package com.nidhogg.studyspringproject.application.dto.user;

import com.nidhogg.studyspringproject.domain.model.user.Role;

public class RegistrationUserDto {

    private String email;
    private String password;
    private Role role;

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
