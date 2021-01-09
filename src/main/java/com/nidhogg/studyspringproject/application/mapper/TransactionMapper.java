package com.nidhogg.studyspringproject.application.mapper;

import com.nidhogg.studyspringproject.domain.model.transaction.Transaction;
import com.nidhogg.studyspringproject.dto.transaction.TransactionDto;
import org.springframework.stereotype.Service;

@Service
public class TransactionMapper {

    public TransactionDto toDto(Transaction transaction) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setId(transaction.getId());
        transactionDto.setAccountIdFrom(transaction.getAccountFrom().getId());
        transactionDto.setAccountIdTo(transaction.getAccountTo().getId());
        transactionDto.setAmount(transaction.getAmount());
        transactionDto.setType(transaction.getType());
        transactionDto.setCategory(transaction.getCategory());
        transactionDto.setCreatedAt(transaction.getCreatedAt());
        return transactionDto;
    }
}
