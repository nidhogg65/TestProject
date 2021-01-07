package com.nidhogg.studyspringproject.domain.model.common;

import javax.persistence.PrePersist;
import java.time.LocalDateTime;

public class EntityListener {

    @PrePersist
    public void beforePersist(Object entity) {
        if (entity instanceof Creatable) {
            ((Creatable) entity).setCreationTimestamp(LocalDateTime.now());
        }
    }
}
