package com.nexcodelab.agendaclinicaser.core.exceptionhandler;

import com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions.CustomExceptionDetails;
import com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions.CustomRestException;
import com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions.ExceptionDetails;
import com.nexcodelab.agendaclinicaser.core.exceptionhandler.exceptions.ValidationExceptionDetails;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Log4j2
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CustomRestException.class)
    public ResponseEntity<CustomExceptionDetails> handleCustomException(CustomRestException exception) {
        return new ResponseEntity<>(
                CustomExceptionDetails.builder().timestamp(LocalDateTime.now())
                        .status(exception.getClass().getAnnotation(ResponseStatus.class).value().value())
                        .title(exception.getTitle())
                        .developerMessage(exception.getDevelopersMessage())
                        .details(exception.getMessage())
                        .developerMessage(exception.getDevelopersMessage()).build(),
                exception.getClass().getAnnotation(ResponseStatus.class).value());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        String fields = fieldErrors.stream().map(FieldError::getField)
                .collect(Collectors.joining(", "));
        String fieldsMessage = fieldErrors.stream().map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(", "));

        return new ResponseEntity<>(ValidationExceptionDetails.builder()
                .timestamp(LocalDateTime.now()).status(HttpStatus.BAD_REQUEST.value())
                .title("Bad Request Exception")
                .details("Check developerMessage")
                .developerMessage(ex.getClass().getName() + " " + ex.getAllErrors().stream().collect(Collectors.mapping(erro -> erro.getDefaultMessage(), Collectors.joining(","))))
                .fields(fields)
                .fieldsMessage(fieldsMessage).build(), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder().build();
        try {
            String title = ex.getCause() != null ? ex.getCause().getMessage() : "Unknown error";
            exceptionDetails = ExceptionDetails.builder().timestamp(LocalDateTime.now())
                    .status(statusCode.value()).title(title)
                    .details(ex.getMessage()).developerMessage(ex.getClass().getName()).build();

        } catch (NullPointerException e) {
            log.error("An error occurred while handling an exception internally", e);
            exceptionDetails = ExceptionDetails.builder().timestamp(LocalDateTime.now())
                    .status(statusCode.value()).title("Internal Server Error")
                    .details("An unexpected error occurred").developerMessage(e.getMessage()).build();
        }

        return new ResponseEntity<>(exceptionDetails, headers, statusCode);
    }
}
