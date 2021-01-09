package com.nidhogg.studyspringproject.service.transaction;

import com.nidhogg.studyspringproject.dto.transaction.CreateTransactionDto;
import com.nidhogg.studyspringproject.dto.transaction.TransactionDto;

public interface TransactionService {

    TransactionDto create(CreateTransactionDto createTransactionDto);

}
