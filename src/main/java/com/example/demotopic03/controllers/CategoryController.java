package com.example.demotopic03.controllers;

import com.example.demotopic03.models.Category;
import com.example.demotopic03.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/all")
    public String showAllCategory(Model model){
        List<Category> categories = this.categoryService.getAll();

        model.addAttribute("categories", categories);
        return "category/all-category";
    }
}
