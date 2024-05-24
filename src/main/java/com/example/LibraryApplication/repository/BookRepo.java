package com.example.LibraryApplication.repository;

import com.example.LibraryApplication.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
    boolean existsByTitle(String title);
}
