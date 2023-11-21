package com.compunet.bookstore.controllers;

import com.compunet.bookstore.persistence.dto.AuthorDto;
import com.compunet.bookstore.persistence.dto.BookDto;
import com.compunet.bookstore.persistence.models.Author;
import com.compunet.bookstore.persistence.models.Book;
import com.compunet.bookstore.services.impl.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@CrossOrigin(maxAge = 3600)
public class AuthorController {

    private final AuthorService autorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.autorService = authorService;
    }

    @GetMapping("/autores")
    public List<AuthorDto> getAutors(){
        return autorService.getAllAuthor();
    }


    @GetMapping("/autores/{id}")
    public Optional<AuthorDto> getAutor(@PathVariable("id") Long id){
        return autorService.getDetails(id);
    }

    @PostMapping("/autores")
    public void createAutor(@RequestBody Author author){autorService.createAutor(author);}

    @PutMapping("autores/{id}")
    public void editAutor(@RequestBody Author author){
        autorService.editAutor(author);
    }

    @DeleteMapping("/autores/{id}")
    public void deleteAutor(@PathVariable("id") Long id){
        autorService.deleteAutor(id);
    }

    @GetMapping("autores/{id}/libros")
    public List<BookDto> getBooksByAutor(@PathVariable("id") Long id){
        return autorService.getBookByAutor(id);
    }

}
