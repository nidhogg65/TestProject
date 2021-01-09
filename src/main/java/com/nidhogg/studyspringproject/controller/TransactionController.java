package com.nidhogg.studyspringproject.controller;

import com.nidhogg.studyspringproject.dto.transaction.CreateTransactionDto;
import com.nidhogg.studyspringproject.dto.transaction.TransactionDto;
import com.nidhogg.studyspringproject.service.transaction.TransactionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/rest/api/v1")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transactions")
    public TransactionDto create(@Valid @RequestBody CreateTransactionDto transactionDto) {
        return transactionService.create(transactionDto);
    }
}
