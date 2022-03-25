package com.madthreed.questionspringboot.exeption;

public class NotFoundAnswerException extends RuntimeException {

    public NotFoundAnswerException(Long id) {
        super("Not found answer with id: " + id);
    }
}
