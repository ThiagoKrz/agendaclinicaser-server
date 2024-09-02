package com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestRestException extends CustomRestException {
    public BadRequestRestException(String message) {
        super(message);
    }

    @Override
    public String getTitle() {
        return  "Bad Request Exception, Check details.";
    }

    @Override
    protected String getDevMessage() {
        return "A request não foi aceita.";
    }
}