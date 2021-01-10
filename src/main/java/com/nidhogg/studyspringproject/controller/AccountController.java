package com.nidhogg.studyspringproject.controller;

import com.nidhogg.studyspringproject.dto.account.AccountDto;
import com.nidhogg.studyspringproject.dto.account.CreateAccountDto;
import com.nidhogg.studyspringproject.service.account.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/rest/api/v1")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping("/users/{userUuid}/accounts")
    @ResponseStatus(code = HttpStatus.CREATED)
    public AccountDto create(@PathVariable String userUuid, @Valid @RequestBody CreateAccountDto accountDto) {
        return accountService.create(userUuid, accountDto);
    }
}
