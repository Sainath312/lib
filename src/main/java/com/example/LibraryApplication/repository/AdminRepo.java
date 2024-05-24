package com.example.LibraryApplication.repository;


import com.example.LibraryApplication.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AdminRepo extends JpaRepository<Admin,Long> {

    Optional<Admin> findByUserName(String adminName);
    Optional<Admin> findByEmail(String emailID);

}
