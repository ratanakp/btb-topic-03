package com.example.demotopic03.models;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Category {

    private Integer id;
    private String name;

    private List<Book> books;

    private Date created_at;
    private LocalDateTime updated_at;

    public Category() {
    }

    public Category(Integer id, String name, List<Book> books, Date created_at, LocalDateTime updated_at) {
        this.id = id;
        this.name = name;
        this.books = books;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
