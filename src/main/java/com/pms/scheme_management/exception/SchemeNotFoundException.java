package com.pms.scheme_management.exception;

public class SchemeNotFoundException extends RuntimeException{
    public SchemeNotFoundException(String message) {
        super(message);
    }
}
