package com.example.LibraryApplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExceptionModel {
    public String status;
    public String errorMessage;
    public String path;
}
