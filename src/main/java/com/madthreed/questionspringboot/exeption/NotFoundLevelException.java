package com.madthreed.questionspringboot.exeption;

public class NotFoundLevelException extends RuntimeException {

    public NotFoundLevelException(Long id) {
        super("Not found level with id: " + id);
    }
}
