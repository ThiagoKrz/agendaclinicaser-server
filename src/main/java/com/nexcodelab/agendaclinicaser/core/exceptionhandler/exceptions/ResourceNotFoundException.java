package com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends CustomRestException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getTitle() {
        return "Recurso não encontrado Exception, Check details.";
    }

    @Override
    protected String getDevMessage() {
        return getMessage();
    }
}
