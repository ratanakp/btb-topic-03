package com.example.demotopic03.repositories;

import com.example.demotopic03.models.Category;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository {


    @Select("select * from tb_category")
    List<Category> getAll();
}
