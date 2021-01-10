package com.nidhogg.studyspringproject.dto.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nidhogg.studyspringproject.domain.model.account.AccountCurrency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class CreateAccountDto {

    @NotNull
    private AccountCurrency currency;
    @JsonProperty("user_id")
    private String userUuid;
}
