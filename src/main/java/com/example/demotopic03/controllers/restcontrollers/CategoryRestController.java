package com.example.demotopic03.controllers.restcontrollers;


import com.example.demotopic03.models.Category;
import com.example.demotopic03.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryRestController {


    private CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("")
    public Map<String, Object> gelAll() {
        Map<String, Object> response = new HashMap<>();

        List<Category> categories = this.categoryService.getAll();

        if(categories != null) {
            response.put("categories", categories);
            response.put("status", true);
            response.put("message", "Category found!");
            response.put("record_count", categories.size());
        }
        else {
            response.put("status", false);
            response.put("message", "Category not found!");
            response.put("record_count", categories.size());
        }

        return response;
    }
}
