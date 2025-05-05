package com.echange.servicesechanges.exception;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
    private HttpStatus httpStatus;
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    private String message;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorResponse() {}
    public ErrorResponse(HttpStatus httpStatus, String message) {
        this.setHttpStatus(httpStatus);
        this.setMessage(message);
    }
}
