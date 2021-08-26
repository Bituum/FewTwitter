package com.example.twitt.util;

import lombok.NoArgsConstructor;

public class TestNotFoundException extends RuntimeException{
    public TestNotFoundException(int id){
        super("Could not find test + " + id);
    }
}
