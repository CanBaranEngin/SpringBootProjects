package com.bookstore.bookstore.api;

import com.bookstore.bookstore.model.dto.BookDto;
import com.bookstore.bookstore.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto book){
        BookDto createdBook = bookService.createBook(book);
        return ResponseEntity.ok(createdBook);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<BookDto>> getBooks(){
        List<BookDto> books=bookService.getBooks();
        return ResponseEntity.ok(books);

    }

 /*   @GetMapping("/getById/{id}")
    public ResponseEntity<BookDto> getByIdBook(@PathVariable ("id") Long id){
        Book getBook=bookService.getBookById(id);
        return ResponseEntity.ok(getBook);
    }*/

    @PutMapping("/updateBooks/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable ("id") Long id,@RequestBody BookDto book){
        BookDto updatedBook=bookService.updateBook(id,book);
        return ResponseEntity.ok(updatedBook);
    }
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Boolean> deleteBook (@PathVariable("id") Long id){
        Boolean status = bookService.deleteBook(id);
        return ResponseEntity.ok(status);

    }
}
