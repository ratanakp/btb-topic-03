package com.example.demotopic03.repositories;

import com.example.demotopic03.models.Book;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    Faker faker = new Faker();

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


    public List<Book> getAll(){
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
            if(bookList.get(i).getId() == book.getId()) {
                bookList.set(i, book);
                return true;
            }
        }
        return false;
    }

}
