package com.example.demotopic03.utilities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
*
* TODO: This Paginate class is for front-end page, but can also use both with api
*
* */
public class Paginate {

    private int page;
    private int limit;

    @JsonProperty("total_count")
    private int totalCount;

    @JsonProperty("total_page")
    private int totalPages;


    @JsonProperty("next_page")
    @JsonIgnore
    private int nextPage;

    @JsonProperty("previous_page")
    @JsonIgnore
    private int previousPage;

    @JsonProperty("page_to_show")
    @JsonIgnore
    private int pagesToShow;

    @JsonProperty("start_page")
    @JsonIgnore
    private int startPage;

    @JsonProperty("end_page")
    @JsonIgnore
    private int endPage;

    @JsonIgnore
    private int offset;

    public Paginate() {
        this(1, 5, 0, 0, 5);
    }

    public Paginate(int page, int limit, int totalCount, int totalPages, int pagesToShow) {
        this.page = page;
        this.limit = limit;
        this.totalCount = totalCount;
        this.totalPages = totalPages;
        this.pagesToShow = pagesToShow;
    }


    public Paginate(int page, int limit, int totalCount, int totalPages, int nextPage, int previousPage, int pagesToShow, int startPage, int endPage, int offset) {
        this.page = page;
        this.limit = limit;
        this.totalCount = totalCount;
        this.totalPages = totalPages;
        this.nextPage = nextPage;
        this.previousPage = previousPage;
        this.pagesToShow = pagesToShow;
        this.startPage = startPage;
        this.endPage = endPage;
        this.offset = offset;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int currentPage) {
        this.page = (currentPage <= 1) ? 1 : currentPage;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotalPages() {
        return (int) Math.ceil((double) this.totalCount / limit);
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getOffset() {
        return (this.page - 1) * this.limit;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getNextPage() {
        return (int) (page >= getTotalPages() ? getTotalPages() : page + 1);
    }

    public int getPreviousPage() {
        return (page <= 1) ? 1 : page - 1;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public int getPagesToShow() {
        return pagesToShow;
    }

    public void setPagesToShow(int pagesToShow) {
        this.pagesToShow = pagesToShow;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;

        this.offset = this.getOffset();
        this.totalPages = this.getTotalPages();
        this.nextPage = this.getNextPage();
        this.previousPage = this.getPreviousPage();

        this.setStartPageEndPage(getTotalPages());
    }

    private void setStartPageEndPage(int totalPages) {
        int halfPagesToShow = pagesToShow / 2;

        if (totalPages <= pagesToShow) {
            startPage = 1;
            endPage = totalPages;

        } else if (page - halfPagesToShow <= 0) {
            startPage = 1;
            endPage = pagesToShow;

        } else if (page + halfPagesToShow == totalPages) {
            startPage = page - halfPagesToShow;
            endPage = totalPages;

        } else if (page + halfPagesToShow > totalPages) {
            startPage = totalPages - pagesToShow + 1;
            endPage = totalPages;

        } else {
            startPage = page - halfPagesToShow;
            endPage = page + halfPagesToShow;
        }
    }

    @Override
    public String toString() {
        return "Paginate{" +
                "page=" + page +
                ", limit=" + limit +
                ", totalCount=" + totalCount +
                ", totalPages=" + totalPages +
                ", nextPage=" + nextPage +
                ", previousPage=" + previousPage +
                ", pagesToShow=" + pagesToShow +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                ", offset=" + offset +
                '}';
    }
}
