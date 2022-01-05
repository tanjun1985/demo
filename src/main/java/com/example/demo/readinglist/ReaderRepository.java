package com.example.demo.readinglist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReaderRepository extends JpaRepository<Reader, String> {
    @Query(value = "select * from reader where username = ?1", nativeQuery = true)
    Reader findByUsername(String username);
}
