package com.example.demotopic03.repositories;

import com.example.demotopic03.models.Book;
import com.example.demotopic03.repositories.providers.BookProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface BookRepository {

    @SelectProvider(type = BookProvider.class, method = "getAllProvider")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "title", property = "title")
    })
    List<Book> getAll();

    @Select("select * from tb_book where id=#{id}")
    Book findOne(@Param("id") Integer id);


    @Update("update tb_book set title=#{title}, author=#{author}, publisher=#{publisher}, thumbnail=#{thumbnail} where id=#{id}")
    boolean update(Book book);


    @Delete("delete from tb_book where id=#{id}")
    boolean delete(Integer id);

    @InsertProvider(type = BookProvider.class, method = "createProvider")
    boolean create(Book book);


    /*Faker faker = new Faker();



    List<Book> bookList = new ArrayList<>();

    {
        for (int i = 1; i < 11; i++) {
            Book book = new Book();

            book.setId(i);
            book.setTitle(faker.book().title());
            book.setAuthor(faker.book().author());
            book.setPublisher(faker.book().publisher());
            bookList.add(book);
        }
    }


    public List<Book> getAll() {
        return this.bookList;
    }


    public Book findOne(Integer id) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId() == id) {
                return bookList.get(i);
            }
        }

        return null;
    }


    public boolean update(Book book) {

        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId() == book.getId()) {
                bookList.set(i, book);
                return true;
            }
        }
        return false;
    }


    public boolean delete(Integer id) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId() == id) {
                bookList.remove(i);
                return true;
            }
        }

        return false;
    }


    public boolean create(Book book) {
        return bookList.add(book);
    }

*/
}
