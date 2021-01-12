package com.nidhogg.studyspringproject.dto.account;

import com.nidhogg.studyspringproject.domain.model.account.AccountCurrency;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class CreateAccountDto {

    @NotNull
    private final AccountCurrency currency;

}
