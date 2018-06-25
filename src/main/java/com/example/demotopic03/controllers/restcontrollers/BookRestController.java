package com.example.demotopic03.controllers.restcontrollers;


import com.example.demotopic03.models.Book;
import com.example.demotopic03.models.filters.BookFilter;
import com.example.demotopic03.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/ajax/book")
public class BookRestController {


    private BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }



    @GetMapping("/all")
    @ResponseBody
    public List<Book> getAll() {
        return this.bookService.getAll();
    }


    @GetMapping("/filter")
    @ResponseBody
    public List<Book> getFilter(BookFilter bookFilter) {
        return this.bookService.bookFilter(bookFilter);
    }



}
