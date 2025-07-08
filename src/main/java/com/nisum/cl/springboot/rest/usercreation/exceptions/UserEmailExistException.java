package com.nisum.cl.springboot.rest.usercreation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserEmailExistException extends RuntimeException {
    public UserEmailExistException(String message) {
        super(message);
    }
    public UserEmailExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
