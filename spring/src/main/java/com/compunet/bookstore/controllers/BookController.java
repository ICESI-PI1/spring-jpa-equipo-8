package com.compunet.bookstore.controllers;

import com.compunet.bookstore.persistence.dto.BookDto;
import com.compunet.bookstore.persistence.models.Book;
import com.compunet.bookstore.services.impl.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@CrossOrigin(maxAge = 3600)
public class BookController {
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/libros")
    public List<BookDto> listBooks() {
        return bookService.getAllBook();
    }

    @GetMapping("/libros/{id}")
    public Optional<BookDto> detailedBook(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping("/libros")
    public void saveBook(@RequestBody Book book){
        System.out.println(book);
        bookService.save(book);
    }

    @PutMapping("/libros/{id}")
    public void editBook(@PathVariable Long id, @RequestBody Book book){
        book.setId(id);
        bookService.edit(book);
    }

    @DeleteMapping("/libros/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }


}
