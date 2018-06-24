package com.example.demotopic03.models.filters;

public class BookFilter {

    private String bookTitle;
    private String cateName;


    public BookFilter() {
    }





    public BookFilter(String bookTitle, String cateName) {
        this.bookTitle = bookTitle;
        this.cateName = cateName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    @Override
    public String toString() {
        return "BookFilter{" +
                "bookTitle='" + bookTitle + '\'' +
                ", cateName='" + cateName + '\'' +
                '}';
    }
}
