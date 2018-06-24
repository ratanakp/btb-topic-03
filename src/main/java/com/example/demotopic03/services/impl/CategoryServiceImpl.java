package com.example.demotopic03.services.impl;

import com.example.demotopic03.models.Category;
import com.example.demotopic03.repositories.CategoryRepository;
import com.example.demotopic03.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAll() {
        return this.categoryRepository.getAll();
    }


    @Override
    public Integer count() {
        return this.categoryRepository.count();
    }
}
