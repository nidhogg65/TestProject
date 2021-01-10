package com.nidhogg.studyspringproject.domain.model.account;

import com.nidhogg.studyspringproject.domain.model.common.BaseDomainEntity;
import com.nidhogg.studyspringproject.domain.model.common.EntityListener;
import com.nidhogg.studyspringproject.domain.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@EntityListeners(EntityListener.class)
@Entity
@Table(name = "ACCOUNT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseDomainEntity {

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "CURRENCY")
    private AccountCurrency currency;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User accountHolder;

    public void addMoney(BigDecimal augend) {
        this.amount = this.amount.add(augend);
    }

    public void subtractMoney(BigDecimal subtrahend) {
        this.amount = this.amount.subtract(subtrahend);
    }
}
