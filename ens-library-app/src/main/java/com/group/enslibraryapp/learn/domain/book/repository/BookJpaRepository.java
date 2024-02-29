package com.group.enslibraryapp.learn.domain.book.repository;

import com.group.enslibraryapp.learn.domain.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookJpaRepository extends JpaRepository<Book,Long> {

    Optional<Book> findByName(String name);
}
