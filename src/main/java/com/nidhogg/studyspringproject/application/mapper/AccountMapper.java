package com.nidhogg.studyspringproject.application.mapper;

import com.nidhogg.studyspringproject.domain.model.account.Account;
import com.nidhogg.studyspringproject.dto.account.AccountDto;
import org.springframework.stereotype.Service;

@Service
public class AccountMapper {

    public AccountDto toDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setUuid(account.getUuid());
        accountDto.setAmount(account.getAmount());
        accountDto.setCurrency(account.getCurrency());
        accountDto.setUserUuid(account.getAccountHolder().getUuid());
        return accountDto;
    }
}
