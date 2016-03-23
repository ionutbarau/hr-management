package com.learn.hr.hrserver.error;

import org.springframework.http.HttpStatus;

/**
 * Created by x01027037 on 23.03.2016.
 */
public class Rest404Exception extends RestException{

    public Rest404Exception(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
