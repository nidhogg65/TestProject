package com.nidhogg.studyspringproject.domain.model.transaction;

import com.nidhogg.studyspringproject.domain.model.account.Account;
import com.nidhogg.studyspringproject.domain.model.common.BaseDomainEntity;
import com.nidhogg.studyspringproject.domain.model.common.Creatable;
import com.nidhogg.studyspringproject.domain.model.common.EntityListener;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@EntityListeners(EntityListener.class)
@Entity
@Table(name = "TRANSACTION")
@Getter
@Setter
@NoArgsConstructor
public class Transaction extends BaseDomainEntity implements Creatable {

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID_FROM")
    private Account accountFrom;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID_TO")
    private Account accountTo;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "TYPE")
    private TransactionType type;

    @Column(name = "CATEGORY")
    private Category category;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    public Transaction(Account accountFrom, Account accountTo, BigDecimal amount, TransactionType type,
                       Category category) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
        this.type = type;
        this.category = category;
    }

    @Override
    public void setCreationTimestamp(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
