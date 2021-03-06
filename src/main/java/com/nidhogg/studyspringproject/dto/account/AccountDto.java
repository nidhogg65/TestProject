package com.nidhogg.studyspringproject.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nidhogg.studyspringproject.domain.model.account.AccountCurrency;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    @JsonProperty("id")
    private String uuid;
    private BigDecimal amount;
    private AccountCurrency currency;
    @JsonProperty("user_id")
    private String userUuid;
}
