package com.nidhogg.studyspringproject.domain.model.transaction;

import com.nidhogg.studyspringproject.domain.model.account.Account;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "TRANSACTION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

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

    @Column(name = "TIMESTAMP")
    private LocalDateTime timestamp;
}
