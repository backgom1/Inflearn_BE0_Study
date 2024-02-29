package com.group.enslibraryapp.learn.domain.book.controller;


import com.group.enslibraryapp.learn.domain.book.dto.request.BookLoanRequest;
import com.group.enslibraryapp.learn.domain.book.dto.request.BookReturnRequest;
import com.group.enslibraryapp.learn.domain.book.dto.request.BookSaveRequest;
import com.group.enslibraryapp.learn.domain.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/book")
    public void saveBook(@RequestBody BookSaveRequest request) {
        bookService.saveBook(request);
    }

    @PostMapping("/book/loan")
    public void loanBook(@RequestBody BookLoanRequest request) {
        bookService.loanBook(request);
    }

    @PutMapping("/book/return")
    public void returnBook(@RequestBody BookReturnRequest request) {
        bookService.returnBook(request);
    }
}
