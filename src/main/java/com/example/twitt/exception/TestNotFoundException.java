package com.example.twitt.exception;

public class TestNotFoundException extends RuntimeException{
    public TestNotFoundException(int id){
        super("Could not find test + " + id);
    }
}
