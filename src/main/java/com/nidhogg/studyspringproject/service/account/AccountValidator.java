package com.nidhogg.studyspringproject.service.account;

import com.nidhogg.studyspringproject.application.exception.AccountDoesNotExistForUserException;
import com.nidhogg.studyspringproject.application.exception.NotEnoughMoneyException;
import com.nidhogg.studyspringproject.domain.model.account.Account;
import com.nidhogg.studyspringproject.security.authentication.AuthenticatedUserHolder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class AccountValidator {

    private final AuthenticatedUserHolder authenticatedUserHolder;

    private boolean hasEnoughMoney(Account account, BigDecimal amount) {
        return account.getAmount().compareTo(amount) >= 0;
    }

    private boolean doesAccountBelongToCurrentUser(Account account) {
        return authenticatedUserHolder.getCurrentUser().getAccounts().stream()
                .map(Account::getUuid)
                .anyMatch(uuid -> uuid.equals(account.getUuid()));

    }

    public void validateSenderAccount(Account senderAccount, BigDecimal amount) {
        if (!doesAccountBelongToCurrentUser(senderAccount)) {
            throw new AccountDoesNotExistForUserException(senderAccount.getUuid());
        }

        if (!hasEnoughMoney(senderAccount, amount)) {
            throw new NotEnoughMoneyException();
        }
    }

}
