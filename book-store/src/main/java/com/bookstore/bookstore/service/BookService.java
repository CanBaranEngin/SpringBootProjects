package com.bookstore.bookstore.service;

import com.bookstore.bookstore.model.dto.BookDto;
import com.bookstore.bookstore.model.entity.Book;

import java.util.List;

public interface BookService {

    BookDto createBook(BookDto book);
    List<BookDto> getBooks();
    Book getBookById(Long id);
    BookDto updateBook(Long id, BookDto book);
    Boolean deleteBook(Long id);

}
