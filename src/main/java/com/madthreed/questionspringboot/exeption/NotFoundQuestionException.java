package com.madthreed.questionspringboot.exeption;

public class NotFoundQuestionException extends RuntimeException {

    public NotFoundQuestionException(Long id) {
        super("Not found question with id: " + id);
    }
}
