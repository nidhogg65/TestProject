package com.nidhogg.studyspringproject.service.account;

import com.nidhogg.studyspringproject.domain.model.account.Account;
import com.nidhogg.studyspringproject.domain.model.user.User;
import com.nidhogg.studyspringproject.domain.repository.account.AccountRepository;
import com.nidhogg.studyspringproject.domain.repository.user.UserRepository;
import com.nidhogg.studyspringproject.dto.account.AccountDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountService(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public AccountDto create(Long userId, AccountDto accountDto) {
        User user = userRepository.getOne(userId);

        Account account = new Account();
        account.setAccountHolder(user);
        account.setAmount(BigDecimal.ZERO);
        account.setCurrency(accountDto.getCurrency());

        Account createdAccount = accountRepository.save(account);


        return new AccountDto(createdAccount.getId(),
                createdAccount.getAmount(),
                createdAccount.getCurrency(),
                createdAccount.getAccountHolder().getId());
    }
}
