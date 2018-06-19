package com.example.demotopic03.repositories.providers;

import com.example.demotopic03.models.Book;
import org.apache.ibatis.jdbc.SQL;

public class BookProvider {

    public String getAllProvider() {
        return new SQL(){{
            SELECT("*");
            FROM("tb_book b");
            INNER_JOIN("tb_category c ON b.cate_id = c.id");
            ORDER_BY("b.id desc");
        }}.toString();
    }


    public String createProvider(Book book) {
        return new SQL(){{
            INSERT_INTO("tb_book");
            VALUES("title", "#{title}");
            VALUES("author", "#{author}");
            VALUES("publisher", "#{publisher}");
            VALUES("thumbnail", "#{thumbnail}");
            VALUES("cate_id", "#{category.id}");
        }}.toString();

    }



}
