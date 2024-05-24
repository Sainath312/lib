package com.example.LibraryApplication.repository;

import com.example.LibraryApplication.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepo extends JpaRepository<Publisher,Long> {
    boolean existsByName(String name);
}
