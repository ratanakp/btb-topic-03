package com.example.demotopic03.models;


import javax.validation.constraints.*;
import java.util.List;

public class Book {

    @NotNull
    private Integer id;

    @Size(min = 5, max = 255)
    @Email
    private String title;

//    @NotNull(message = "{1} meme Custom!")
    private String author;

    private String publisher;

    private String thumbnail;

    public Book() {
    }

    public Book(@NotNull Integer id, @Size(min = 5, max = 255) @Email String title, String author, String publisher, String thumbnail) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.thumbnail = thumbnail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}
