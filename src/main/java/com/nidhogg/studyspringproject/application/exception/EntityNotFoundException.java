package com.nidhogg.studyspringproject.application.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Class<?> entityClass) {
        super(entityClass.getSimpleName() + " with such identificator does not exist.");
    }
}
