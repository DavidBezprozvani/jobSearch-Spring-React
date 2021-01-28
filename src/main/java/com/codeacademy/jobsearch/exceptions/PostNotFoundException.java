package com.codeacademy.jobsearch.exceptions;

public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(Long id) {
        super("There is no post with id:" + id);
    }
}