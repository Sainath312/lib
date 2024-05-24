package com.example.LibraryApplication.service;

import com.example.LibraryApplication.entity.Book;
import com.example.LibraryApplication.entity.Publisher;
import com.example.LibraryApplication.exceptions.AlreadyExists;
import com.example.LibraryApplication.exceptions.NotFoundException;
import com.example.LibraryApplication.model.BaseResponse;
import com.example.LibraryApplication.model.BookModel;
import com.example.LibraryApplication.model.ResponseMessage;
import com.example.LibraryApplication.repository.BookRepo;
import com.example.LibraryApplication.repository.PublisherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookServices {

    @Autowired
    private PublisherRepo publisherRepo;

    @Autowired
    public BookRepo bookRepository;

    public BaseResponse<Object> saveBook(BookModel bookRequest) {
        Optional<Publisher> publisher = publisherRepo.findById(bookRequest.getPublisherId());
        if (bookRepository.existsByTitle(bookRequest.getTitle())) {
            throw new AlreadyExists("Book with name " + bookRequest.getTitle() + " already exists");
        }
        if (publisher.isEmpty()) {
            return BaseResponse.builder().status(HttpStatus.NOT_FOUND).errorMessage("Publisher Not Present " + bookRequest.getPublisherId()).build();
        }
        Book book = bookRepository.save(Book.builder()
                .title(bookRequest.getTitle())
                .author(bookRequest.getAuthor())
                .category(bookRequest.getCategory())
                .description(bookRequest.getDescription())
                .publisher(publisher.get())
                .build());
        return BaseResponse.builder()
                .status(HttpStatus.OK)
                .data(book)
                .build();
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Book with id " + id + " not found")
        );
    }

    public ResponseMessage deleteBook(Long id) {
        List<Book> book = bookRepository.findById(id);
        if (book != null) {
            bookRepository.deleteById(id);
            return ResponseMessage()
        }
    }

    public Book updateBook(Book updateBook) {
        Long id = updateBook.getId();
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(updateBook.getTitle());
                    book.setAuthor(updateBook.getAuthor());
                    book.setCategory(updateBook.getCategory());
                    book.setDescription(updateBook.getDescription());
                    book.setPublisher(updateBook.getPublisher());
                    return book;
                })
                .orElseThrow(() -> new NotFoundException("Book with id " + id + " not found"));
    }

}
