package com.nidhogg.studyspringproject.service.account;

import com.nidhogg.studyspringproject.application.exception.EntityNotFoundException;
import com.nidhogg.studyspringproject.application.mapper.AccountMapper;
import com.nidhogg.studyspringproject.domain.model.account.Account;
import com.nidhogg.studyspringproject.domain.model.user.User;
import com.nidhogg.studyspringproject.domain.repository.account.AccountRepository;
import com.nidhogg.studyspringproject.domain.repository.user.UserRepository;
import com.nidhogg.studyspringproject.dto.account.AccountDto;
import com.nidhogg.studyspringproject.dto.account.CreateAccountDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final AccountMapper accountMapper;

    public AccountService(AccountRepository accountRepository,
                          UserRepository userRepository,
                          AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.accountMapper = accountMapper;
    }

    @Transactional
    public AccountDto create(String userUuid, CreateAccountDto createAccountDto) {
        User user = userRepository.findByUuid(userUuid)
                .orElseThrow(() -> new EntityNotFoundException(User.class));

        Account createdAccount = accountRepository.save(
                new Account(BigDecimal.ZERO, createAccountDto.getCurrency(), user));
        return accountMapper.toDto(createdAccount);
    }

    // TODO: Add validation
    @Transactional
    public void executeMoneyTransfer(Account sourceAccount, Account targetAccount, BigDecimal amount) {
        sourceAccount.subtractMoney(amount);
        targetAccount.addMoney(amount);
        accountRepository.saveAll(List.of(sourceAccount, targetAccount));
    }
}
