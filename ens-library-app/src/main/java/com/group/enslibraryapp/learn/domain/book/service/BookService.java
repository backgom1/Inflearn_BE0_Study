package com.group.enslibraryapp.learn.domain.book.service;

import com.group.enslibraryapp.learn.domain.book.repository.BookMysqlRepository;
import com.group.enslibraryapp.learn.domain.book.repository.BookRepository;
import com.group.enslibraryapp.learn.domain.book.repository.IBookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

   private final IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void saveBook() {
        bookRepository.saveBook();
    }
}
