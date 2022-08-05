package com.bookstore.bookstore.service.impl;

import com.bookstore.bookstore.model.dto.BookDto;
import com.bookstore.bookstore.model.entity.Book;
import com.bookstore.bookstore.repository.BookRepository;
import com.bookstore.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private  final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    @Override
    public BookDto createBook(BookDto bookDto){
        Book book = modelMapper.map(bookDto, Book.class);
        book.setCreatedDate(new Date());
        book.setCreatedBy("Admin");
        return modelMapper.map(bookRepository.save(book),BookDto.class);
    }

    @Override
    public List<BookDto> getBooks(){
        List<Book> books =bookRepository.findAll();
        List<BookDto> bookDto = books.stream().map(book -> modelMapper.map(book,BookDto.class)).collect(Collectors.toList());
        return bookDto;
    }

    @Override
    public Book getBookById(Long id){
        Optional<Book> book = bookRepository.findById(id);
        return book.orElseThrow(() -> new RuntimeException());
/*        if(book.isPresent()){
            return ;
        }
        return null;*/

    }

    @Override
    public BookDto updateBook(Long id,BookDto book){
        Optional<Book> resultBook = bookRepository.findById(id);

        if(resultBook.isPresent()){
            if(book.getGenreId()!=0){
                resultBook.get().setGenreId(book.getGenreId());
            }
            if(book.getTitle()!=null){
                resultBook.get().setTitle(book.getTitle());
            }
            if(book.getPageCount()!=0){
                resultBook.get().setPageCount(book.getPageCount());
            }
            resultBook.get().setUpdatedAt(new Date());
            resultBook.get().setUpdatedBy("Admin");
            return modelMapper.map(bookRepository.save(resultBook.get()),BookDto.class);
        }
        return null;

    }

    @Override
    public Boolean deleteBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);

        if(book.isPresent()){
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
