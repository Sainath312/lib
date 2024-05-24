package com.example.LibraryApplication.repository;

import com.example.LibraryApplication.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepo extends JpaRepository<Session,Long> {

    Session findByUserId(Long id);
}
