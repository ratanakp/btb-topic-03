package com.example.demotopic03.controllers;


import com.example.demotopic03.models.Book;
import com.example.demotopic03.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping({"/index", "/", "home"})
//    @RequestMapping(value = {"/index", "/", "/home"}, method = RequestMethod.GET)
    public String index(ModelMap model) {

        List<Book> bookList = this.bookService.getAll();

        model.addAttribute("books", bookList);

        return "book/index";
    }


    @GetMapping("view/{id}")
    public String view(@PathVariable("id") Integer id, Model model) {
        System.out.println("ID: " + id);


        Book book = this.bookService.findOne(id);

        model.addAttribute("book", book);

        return "book/view-detail";

    }


    @GetMapping("/update/{book_id}")
    public String showFormUpdate(@PathVariable Integer book_id, ModelMap modelMap) {
        System.out.println("ID to update: " + book_id);

        Book book = this.bookService.findOne(book_id);

        modelMap.addAttribute("book", book);

        return "book/update";
    }


    @PostMapping("update/submit")
    public String updateSubmit(@ModelAttribute Book book) {
        System.out.println(book);
        return "redirect:/index";
    }


}
