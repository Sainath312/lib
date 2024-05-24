package com.example.LibraryApplication.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Response {
    public String message;
    public HttpStatus statusCode;

    public Response(String message, HttpStatus statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
