package com.example.LibraryApplication.exceptions;

public class UserNotExists extends RuntimeException{
    public UserNotExists(String message) {
        super(message);
    }
}
