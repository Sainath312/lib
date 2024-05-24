package com.example.LibraryApplication.model;

import com.example.LibraryApplication.entity.Book;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherRequest {

    @NotBlank(message = "Name of the publisher is required")
    private String name;

    @NotBlank(message = "Address of the publisher is required")
    private String address;

    private List<BookModel> books;
}
