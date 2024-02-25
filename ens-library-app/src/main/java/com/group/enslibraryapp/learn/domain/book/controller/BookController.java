package com.group.enslibraryapp.learn.domain.book.controller;


import com.group.enslibraryapp.learn.domain.book.service.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

//    private final BookService bookService = new BookService(); //일반 인스턴스 생성

    @PostMapping("/book")
    public void saveBook() {
//        bookService.saveBook();
    }
}
