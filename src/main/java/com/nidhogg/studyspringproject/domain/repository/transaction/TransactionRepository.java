package com.nidhogg.studyspringproject.domain.repository.transaction;

import com.nidhogg.studyspringproject.domain.model.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
