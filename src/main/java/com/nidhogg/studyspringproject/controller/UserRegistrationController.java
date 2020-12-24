package com.nidhogg.studyspringproject.controller;

import com.nidhogg.studyspringproject.application.dto.user.RegistrationUserDto;
import com.nidhogg.studyspringproject.application.dto.user.UserDto;
import com.nidhogg.studyspringproject.application.service.user.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/rest/api/v1")
public class UserRegistrationController {

    private final UserRegistrationService registrationService;

    @Autowired
    public UserRegistrationController(UserRegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping(path = "/users")
    @ResponseStatus(code = HttpStatus.CREATED)
    public UserDto registerNewUser(@RequestBody @Valid RegistrationUserDto newUser) {
        return registrationService.registerNewUser(newUser);
    }

}
