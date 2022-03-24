package com.madthreed.questionspringboot.exeption;

public class NotFoundProfileException extends RuntimeException {


    public NotFoundProfileException(Long id) {
        super("Not found profile with id: " + id);
    }
}
