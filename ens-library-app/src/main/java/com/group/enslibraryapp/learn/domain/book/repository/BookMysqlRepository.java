package com.group.enslibraryapp.learn.domain.book.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


@Primary
@Repository
public class BookMysqlRepository implements IBookRepository {
    public void saveBook() {

    }
}
