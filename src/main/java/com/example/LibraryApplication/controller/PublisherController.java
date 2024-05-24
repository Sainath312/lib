package com.example.LibraryApplication.controller;

import com.example.LibraryApplication.entity.Publisher;
import com.example.LibraryApplication.model.PublisherRequest;
import com.example.LibraryApplication.model.ResponseMessage;
import com.example.LibraryApplication.service.PublisherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publisher")
public class PublisherController {

    @Autowired
    PublisherService service;

    @PostMapping("/newPublisher")
    public ResponseEntity<Publisher> newPublisher(@RequestBody @Valid PublisherRequest publisher){
        return ResponseEntity.ok(service.newPublisher(publisher));
    }
    @GetMapping("/allPublishers")
    public List<Publisher> allPublishers(){
        return service.getAllPublisher();
    }

    @GetMapping("/{id}")
    public Publisher getByPublisherId(@PathVariable Long id){
        return service.getPublisherById(id);
    }

    @PutMapping("/{id}")
    public Publisher updatePublisher(@RequestBody @Valid Publisher publisher){
        return service.updateBook(publisher);
    }

    @DeleteMapping("/{id}")
    public ResponseMessage deletePublisher(@PathVariable Long id){
        return service.deletePublisher(id);
    }
}
