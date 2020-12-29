package com.nidhogg.studyspringproject.controller;

import com.nidhogg.studyspringproject.dto.account.AccountDto;
import com.nidhogg.studyspringproject.service.account.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/rest/api/v1")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping("/users/{userId}/accounts")
    @ResponseStatus(code = HttpStatus.CREATED)
    public AccountDto create(@PathVariable Long userId, @RequestBody AccountDto accountDto) {
        return accountService.create(userId, accountDto);
    }
}
