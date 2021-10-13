package com.example.twitt.exception;

public class WrongUserLoginOrPasswordException extends RuntimeException {
    public WrongUserLoginOrPasswordException(String message) {
        super(message);
    }
}
