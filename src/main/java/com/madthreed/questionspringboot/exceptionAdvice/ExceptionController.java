package com.madthreed.questionspringboot.exceptionAdvice;

import com.madthreed.questionspringboot.exeption.NotFoundProfileException;
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
}
