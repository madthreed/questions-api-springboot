package com.madthreed.questionspringboot.exceptionAdvice;

import com.madthreed.questionspringboot.exeption.NotFoundAnswerException;
import com.madthreed.questionspringboot.exeption.NotFoundLevelException;
import com.madthreed.questionspringboot.exeption.NotFoundProfileException;
import com.madthreed.questionspringboot.exeption.NotFoundQuestionException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundProfileException.class)
    public String notFoundProfile(NotFoundProfileException e) {
        return e.getMessage();
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundQuestionException.class)
    public String notFoundQuestion(NotFoundQuestionException e) {
        return e.getMessage();
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundLevelException.class)
    public String notFoundLevel(NotFoundLevelException e) {
        return e.getMessage();
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundAnswerException.class)
    public String notFoundAnswer(NotFoundAnswerException e) {
        return e.getMessage();
    }
}
