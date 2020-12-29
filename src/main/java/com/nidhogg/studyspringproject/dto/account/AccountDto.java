package com.nidhogg.studyspringproject.dto.account;

import com.nidhogg.studyspringproject.domain.model.account.AccountCurrency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class AccountDto {

    private Long id;
    private BigDecimal amount;
    private AccountCurrency currency;
    private Long userid;
}
