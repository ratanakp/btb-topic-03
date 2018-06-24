package com.example.demotopic03.controllers;


import com.example.demotopic03.services.BookService;
import com.example.demotopic03.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class DashBoardController {

    private BookService bookService;
    private CategoryService categoryService;

    public DashBoardController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @RequestMapping({"/dashboard", "/"})
    public String dashboard(Model model) {
        Integer countBook = this.bookService.count();
        Integer countCategory = this.categoryService.count();

        model.addAttribute("count_book", countBook);
        model.addAttribute("date", new Date());
        model.addAttribute("count_category", countCategory);

        return "dashboard";
    }

}
