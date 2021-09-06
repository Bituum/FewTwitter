package com.example.twitt.exception;

public class UsernameIsTakenException extends RuntimeException{
    public UsernameIsTakenException(String message) {
        super(message);
    }
}
