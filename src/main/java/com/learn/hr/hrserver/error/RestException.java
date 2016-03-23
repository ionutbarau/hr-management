package com.learn.hr.hrserver.error;

import org.springframework.http.HttpStatus;

/**
 * Created by x01027037 on 17.03.2016.
 */
public class RestException extends RuntimeException{

    private HttpStatus httpStatus;
    private String message;

    public RestException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
