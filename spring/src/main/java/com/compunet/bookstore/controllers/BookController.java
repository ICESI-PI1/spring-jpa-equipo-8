package com.compunet.bookstore.controllers;

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
    public List<Book> listBooks() {
        return bookService.getAll();
    }

    @GetMapping("/libroId")
    public Long getNextId() {return bookService.getNextId();}

    @GetMapping("/libros/{id}")
    public Optional<Book> detailedBook(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping("/libros")
    public void saveBook(@RequestBody Book book){
        bookService.save(book);
    }

    @PutMapping("/libros/{id}")
    public void editBook(@PathVariable Long id, @RequestBody Book book){
        book.setId(id);
        bookService.edit(book);
        bookService.sort();
    }

    @DeleteMapping("/libros/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }


}
