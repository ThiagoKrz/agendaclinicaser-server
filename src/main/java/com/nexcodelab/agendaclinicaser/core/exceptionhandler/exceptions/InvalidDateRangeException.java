package com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidDateRangeException extends CustomRestException {

    public InvalidDateRangeException(String message) {

        super(message);
    }

    @Override
    protected String getDevMessage() {
        return "A request não foi aceita.";
    }

    @Override
    public String getTitle() {
        return  "Invalid Date Range Exception, Check details.";
    }
}

