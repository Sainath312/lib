package com.example.LibraryApplication.service;


import com.example.LibraryApplication.entity.Book;
import com.example.LibraryApplication.entity.Publisher;
import com.example.LibraryApplication.exceptions.AlreadyExists;
import com.example.LibraryApplication.exceptions.NotFoundException;
import com.example.LibraryApplication.model.BookModel;
import com.example.LibraryApplication.model.PublisherRequest;
import com.example.LibraryApplication.model.ResponseMessage;
import com.example.LibraryApplication.repository.PublisherRepo;
import com.example.LibraryApplication.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublisherService {
    @Autowired
    PublisherRepo publisherRepo;

    @Autowired
    Mapper mapper;

    public Publisher newPublisher(PublisherRequest publisher) {
        if (publisherRepo.existsByName(publisher.getName())) {
            throw new AlreadyExists("publisher with name " + publisher.getName() + " already exists");
        }
        List<Book> bookList = publisher.getBooks().stream().map(dto -> mapper.dtoToBook(dto)).collect(Collectors.toList());
        return publisherRepo.save(Publisher.builder()
                .address(publisher.getAddress())
                .name(publisher.getName())
                .books(bookList)
                .build());
    }

    public List<Publisher> getAllPublisher() {
        return publisherRepo.findAll();
    }

    public Publisher getPublisherById(Long id) {
        return publisherRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Publisher with id " + id + " not found"));
    }

    public ResponseMessage deletePublisher(Long id) {
        return publisherRepo.findById(id)
                .map(book -> {
                    publisherRepo.deleteById(id);
                    return new ResponseMessage("Success");
                })
                .orElseThrow(() -> new NotFoundException("Book with id " + id + " not found"));
    }

    public Publisher updateBook(Publisher updatePublisher) {
        Long id = updatePublisher.getId();
        return publisherRepo.findById(id)
                .map(publisher -> {
                    publisher.setName(updatePublisher.getName());
                    publisher.setAddress(updatePublisher.getAddress());
                    publisher.setBooks(updatePublisher.getBooks());
                    return publisher;
                })
                .orElseThrow(() -> new NotFoundException("Book with id " + id + " not found"));
    }
}
