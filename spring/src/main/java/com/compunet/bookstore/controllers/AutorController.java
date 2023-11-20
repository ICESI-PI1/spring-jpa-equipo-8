package com.compunet.bookstore.controllers;

import com.compunet.bookstore.persistence.models.Autor;
import com.compunet.bookstore.persistence.models.Book;
import com.compunet.bookstore.services.impl.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@CrossOrigin(maxAge = 3600)
public class AutorController {

    private final AutorService autorService;

    @Autowired
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping("/autores")
    public List<Autor> getAutors(){
        return autorService.getAllAuthor();
    }

    @GetMapping("/autorId")
    public Long getNextId() {return autorService.getNextId();}

    @GetMapping("/autores/{id}")
    public Optional<Autor> getAutor(@PathVariable("id") Long id){
        return autorService.getDetails(id);
    }

    @PostMapping("/autores")
    public void createAutor(@RequestBody Autor autor){autorService.createAutor(autor);}

    @PutMapping("autores/{id}")
    public void editAutor(@RequestBody Autor autor){
        autorService.editAutor(autor);
        autorService.sort();
    }

    @DeleteMapping("/autores/{id}")
    public void deleteAutor(@PathVariable("id") Long id){
        autorService.deleteAutor(id);
    }

    @GetMapping("autores/{id}/libros")
    public List<Book> getBooksByAutor(@PathVariable("id") Long id){
        return autorService.getBookByAutor(id);
    }

}
