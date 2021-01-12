package com.nidhogg.studyspringproject.dto.account;

import com.nidhogg.studyspringproject.domain.model.account.AccountCurrency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountDto {

    @NotNull
    private AccountCurrency currency;

}
