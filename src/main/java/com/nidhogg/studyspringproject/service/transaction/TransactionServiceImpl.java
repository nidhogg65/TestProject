package com.nidhogg.studyspringproject.service.transaction;

import com.nidhogg.studyspringproject.application.mapper.TransactionMapper;
import com.nidhogg.studyspringproject.domain.model.account.Account;
import com.nidhogg.studyspringproject.domain.model.transaction.Transaction;
import com.nidhogg.studyspringproject.domain.repository.account.AccountRepository;
import com.nidhogg.studyspringproject.domain.repository.transaction.TransactionRepository;
import com.nidhogg.studyspringproject.dto.transaction.CreateTransactionDto;
import com.nidhogg.studyspringproject.dto.transaction.TransactionDto;
import com.nidhogg.studyspringproject.service.account.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final AccountService accountService;
    private final TransactionMapper transactionMapper;

    public TransactionServiceImpl(TransactionRepository transactionRepository,
                                  AccountRepository accountRepository,
                                  AccountService accountService,
                                  TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.accountService = accountService;
        this.transactionMapper = transactionMapper;
    }

    @Transactional
    public TransactionDto create(CreateTransactionDto createTransactionDto) {
        Account accountFrom = accountRepository.getOne(createTransactionDto.getAccountIdFrom());
        Account accountTo = accountRepository.getOne(createTransactionDto.getAccountIdTo());

        accountService.executeMoneyTransfer(accountFrom, accountTo, createTransactionDto.getAmount());

        Transaction newTransaction = new Transaction(
                accountFrom,
                accountTo,
                createTransactionDto.getAmount(),
                createTransactionDto.getType(),
                createTransactionDto.getCategory());

        Transaction createdTransaction = transactionRepository.save(newTransaction);

        return transactionMapper.toDto(createdTransaction);
    }

}
