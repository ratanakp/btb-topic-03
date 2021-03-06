package com.example.demotopic03.services.impl;

import com.example.demotopic03.models.Book;
import com.example.demotopic03.repositories.BookRepository;
import com.example.demotopic03.services.BookService;
import com.example.demotopic03.utilities.Paginate;
import com.example.demotopic03.utilities.Pagination;
import com.example.demotopic03.utilities.filters.BookFilter;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Override
    public boolean update(Book book) {
        return this.bookRepository.update(book);
    }

    @Override
    public boolean delete(Integer id) {
        return this.bookRepository.delete(id);
    }

    @Override
    public boolean create(Book book) {
        return this.bookRepository.create(book);
    }

    @Override
    public Integer count() {
        return this.bookRepository.count();
    }


    @Override
    public List<Book> bookFilter(BookFilter bookFilter) {
        return this.bookRepository.bookFilter(bookFilter);
    }

    @Override
    public boolean creates(List<Book> books) {
        return this.bookRepository.creates(books);
    }




    @Override
    public Integer countFilter(BookFilter bookFilter) {
        return this.bookRepository.countFilter(bookFilter);
    }
    @Override
    public List<Book> getBookFilterPagination(BookFilter bookFilter, Pagination pagination) {
        return this.bookRepository.getBookFilterPagination(bookFilter, pagination);
    }

    @Override
    public List<Book> getBookFilterPagination(BookFilter bookFilter, Paginate paginate) {

        return this.bookRepository.getBookFilterPaginate(bookFilter, paginate);
    }

}
