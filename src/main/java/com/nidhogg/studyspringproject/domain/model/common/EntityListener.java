package com.nidhogg.studyspringproject.domain.model.common;

import javax.persistence.PrePersist;
import java.time.LocalDateTime;
import java.util.UUID;

public class EntityListener {

    @PrePersist
    public void beforePersist(Object entity) {
        if (entity instanceof Creatable) {
            ((Creatable) entity).setCreationTimestamp(LocalDateTime.now());
        }
        if (entity instanceof BaseDomainEntity) {
            ((BaseDomainEntity) entity).setUuid(UUID.randomUUID().toString());
        }
    }
}
