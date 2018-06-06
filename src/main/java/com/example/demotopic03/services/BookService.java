package com.example.demotopic03.services;

import com.example.demotopic03.models.Book;

import java.util.List;

public interface BookService {

    List<Book> getAll();

    Book findOne(Integer id);

    boolean update(Book book);

    boolean delete(Integer id);

    boolean create(Book book);
}
