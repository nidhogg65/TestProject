package com.nidhogg.studyspringproject.domain.model.account;

import com.nidhogg.studyspringproject.domain.model.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "ACCOUNT")
@Getter
@Setter
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "CURRENCY")
    private AccountCurrency currency;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User accountHolder;
}
