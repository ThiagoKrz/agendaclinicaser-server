package com.nexcodelab.agendaclinicaser.core.config.exceptionhandler;

import com.nexcodelab.agendaclinicaser.core.config.exceptionhandler.exceptions.CustomExceptionDetails;
import com.nexcodelab.agendaclinicaser.core.config.exceptionhandler.exceptions.CustomRestException;
import com.nexcodelab.agendaclinicaser.core.config.exceptionhandler.exceptions.ExceptionDetails;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Log4j2
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     * this method handles all custom exceptions created.
     * If you want different behavior please don't make your exception extends CustomException
     * and register it here on a new method taking this as reference.
     */
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
        ExceptionDetails exceptionDetails = ExceptionDetails.builder().build();

        try {
            String title = ex.getCause() != null ? ex.getCause().getMessage() : "Unknown error";

            exceptionDetails = ExceptionDetails.builder()
                    .timestamp(LocalDateTime.now())
                    .status(status.value()).title(title)
                    .details(ex.getMessage()).developerMessage(ex.getClass().getName()).build();
        } catch (NullPointerException e) {
            log.error("An error occurred while handling an exception internally", e);

            exceptionDetails = ExceptionDetails.builder().timestamp(LocalDateTime.now())
                    .status(status.value()).title("Internal Server Error")
                    .details("An unexpected error occurred").developerMessage(e.getMessage()).build();
        }

        return new ResponseEntity<>(exceptionDetails, headers, status);
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
