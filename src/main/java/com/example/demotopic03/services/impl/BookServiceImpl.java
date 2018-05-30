package com.example.demotopic03.services.impl;

import com.example.demotopic03.models.Book;
import com.example.demotopic03.repositories.BookRepository;
import com.example.demotopic03.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAll() {
        return this.bookRepository.getAll();
    }

    @Override
    public Book findOne(Integer id) {
        return this.bookRepository.findOne(id);
    }
}
