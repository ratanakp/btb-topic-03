package com.example.demotopic03.services;

import com.example.demotopic03.models.Book;
import com.example.demotopic03.utilities.Paginate;
import com.example.demotopic03.utilities.Pagination;
import com.example.demotopic03.utilities.filters.BookFilter;

import java.util.List;

public interface BookService {

    List<Book> getAll();

    Book findOne(Integer id);

    boolean update(Book book);

    boolean delete(Integer id);

    boolean create(Book book);

    List<Book> bookFilter(BookFilter bookFilter);

    Integer count();


    boolean creates(List<Book> books);



    // all about pagination

    Integer countFilter(BookFilter bookFilter);

    List<Book> getBookFilterPagination(BookFilter bookFilter, Pagination pagination);

    List<Book> getBookFilterPagination(BookFilter bookFilter, Paginate paginate);

}
