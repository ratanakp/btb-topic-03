package com.example.demotopic03.repositories;

import com.example.demotopic03.models.Book;
import com.example.demotopic03.models.Category;
import com.example.demotopic03.repositories.providers.CategoryProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository {

    @Select("select * from tb_category")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(property = "books", column = "id", many = @Many(select = "getBookByCateId"))
    })
    List<Category> getAll();


    @SelectProvider(method = "getBookByCateIdProvider", type = CategoryProvider.class)
    List<Book> getBookByCateId(@Param("id") Integer id);


    @Select("select count(*) from tb_category")
    Integer count();

}
