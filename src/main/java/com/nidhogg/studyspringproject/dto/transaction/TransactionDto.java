package com.nidhogg.studyspringproject.dto.transaction;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nidhogg.studyspringproject.domain.model.transaction.Category;
import com.nidhogg.studyspringproject.domain.model.transaction.TransactionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TransactionDto {
    @JsonProperty("id")
    private String uuid;
    @JsonProperty("account_id_from")
    private String accountUuidFrom;
    @JsonProperty("account_id_to")
    private String accountUuidTo;
    private BigDecimal amount;
    private TransactionType type;
    private Category category;
    @JsonProperty("created_at")
    private LocalDateTime createdAt;
}
