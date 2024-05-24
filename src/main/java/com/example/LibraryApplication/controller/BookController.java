package com.example.LibraryApplication.controller;


import com.example.LibraryApplication.entity.Book;
import com.example.LibraryApplication.model.BaseResponse;
import com.example.LibraryApplication.model.BookModel;
import com.example.LibraryApplication.model.ResponseMessage;
import com.example.LibraryApplication.service.BookServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    BookServices bookServices;

    @PostMapping("/newBook")
    public ResponseEntity<BaseResponse<?>> addBook(@RequestBody @Valid BookModel book) {
        return ResponseEntity.ok(bookServices.saveBook(book));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookDetails(@PathVariable Long id){
        return ResponseEntity.ok(bookServices.getBookById(id));
    }
    @GetMapping("/allBooks")
    public List<Book> getAllBooks(){
        return bookServices.getAllBooks();
    }
    @DeleteMapping("/{id}")
    public ResponseMessage deleteBook(@PathVariable Long id){
        return bookServices.deleteBook(id);
    }
}
