package com.bookstore.bookstore.model.dto;

import lombok.Data;
@Data
public class BookDto {
    private String title;
    private String author;
    private Long pageCount;
    private int genreId;
    private int bookResTime;
}
