package com.learn.hr.hrserver.error;

import org.springframework.http.HttpStatus;

/**
 * Created by x01027037 on 23.03.2016.
 */
public class Rest400Exception extends RestException {

    public Rest400Exception(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
