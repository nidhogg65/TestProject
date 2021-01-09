package com.nidhogg.studyspringproject.dto.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nidhogg.studyspringproject.domain.model.transaction.Category;
import com.nidhogg.studyspringproject.domain.model.transaction.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CreateTransactionDto {

    @JsonProperty("account_id_from")
    @NotNull
    private Long accountIdFrom;

    @JsonProperty("account_id_to")
    @NotNull
    private Long accountIdTo;

    @Positive
    @NotNull
    private BigDecimal amount;

    @NotNull
    private TransactionType type;

    @NotNull
    private Category category;


}
