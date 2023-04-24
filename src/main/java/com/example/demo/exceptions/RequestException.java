package com.example.demo.exceptions;

import lombok.Getter;

@Getter
public class RequestException extends RuntimeException {

    public String code;

    public RequestException(String code, String message) {
        super(message);
        this.code = code;
    }
}
