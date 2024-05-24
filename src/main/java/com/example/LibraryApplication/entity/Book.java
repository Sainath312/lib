package com.example.LibraryApplication.entity;

//Create a Library Management System application that manages books and publishers.
//Implement one-to-one and one-to-many relationships, RESTful endpoints to handle CRUD operations.
//Create publishers and books tables
//publishers table fields:
//    id (Primary Key, Auto Increment), name, address, created_date, updated_date
//books table fields:
//    id (Primary Key, Auto Increment), title, description, category, publisher_id, created_date, updated_date


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Category is required")
    private String category;

    @NotBlank(message = "Author is required")
    private String author;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id",
            referencedColumnName = "publisher_id",
            foreignKey = @ForeignKey(
            name = "fk_books_publisher"
    ))
    @JsonBackReference
    private Publisher publisher;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
