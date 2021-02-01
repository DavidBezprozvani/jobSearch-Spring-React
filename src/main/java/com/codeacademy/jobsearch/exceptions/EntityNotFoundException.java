package com.codeacademy.jobsearch.exceptions;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Long id) {
        super("There is no entity with id:" + id);
    }
}