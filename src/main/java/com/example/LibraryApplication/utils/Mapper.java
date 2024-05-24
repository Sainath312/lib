package com.example.LibraryApplication.utils;

import com.example.LibraryApplication.entity.Book;
import com.example.LibraryApplication.model.BookModel;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public Book dtoToBook(BookModel bookModel) {
        return Book.builder()
                .title(bookModel.getTitle())
                .author(bookModel.getAuthor())
                .description(bookModel.getDescription())
                .category(bookModel.getCategory())
                .build();
    }
}
