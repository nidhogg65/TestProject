package com.nidhogg.studyspringproject.domain.model.common;

import java.time.LocalDateTime;

public interface Creatable {

    void setCreationTimestamp(LocalDateTime createdAt);
}
