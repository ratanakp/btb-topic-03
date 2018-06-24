package com.example.demotopic03.services;

import com.example.demotopic03.models.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();

    Integer count();
}
