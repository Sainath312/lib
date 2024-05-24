package com.example.LibraryApplication.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookModel {

    @NotBlank(message = "Title is must be Required for Book")
    private String title;

    @NotBlank(message = "pls provide the description for the book")
    private String description;

    @NotBlank(message = "catergory is required")
    private String category;

    @NotBlank(message = "pls provide the author for the book")
    private String author;

    private Long publisherId;


}
