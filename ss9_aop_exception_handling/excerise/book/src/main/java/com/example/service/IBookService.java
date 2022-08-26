package com.example.service;

import com.example.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findById(Integer id);
    void update(Book book);
}
