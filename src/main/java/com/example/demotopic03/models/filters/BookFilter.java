package com.example.demotopic03.models.filters;

public class BookFilter {

    private Integer cateId;
    private String bookTitle;


    public BookFilter() {
    }

    public BookFilter(Integer cateId, String bookTitle) {
        this.cateId = cateId;
        this.bookTitle = bookTitle;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @Override
    public String toString() {
        return "BookFilter{" +
                "cateId=" + cateId +
                ", bookTitle='" + bookTitle + '\'' +
                '}';
    }
}
