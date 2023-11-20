package com.compunet.bookstore.services.impl;

import com.compunet.bookstore.persistence.models.Autor;
import com.compunet.bookstore.persistence.models.Book;
import com.compunet.bookstore.persistence.repositories.IAutorRepository;
import com.compunet.bookstore.services.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService implements IAuthorService {

    @Autowired
    private IAutorRepository autorRepository;
    @Override
    public List<Autor> getAllAuthor() {
        return autorRepository.getAllAuthor();
    }

    @Override
    public Optional<Autor> getDetails(Long id) {
        return autorRepository.getDetails(id);
    }

    @Override
    public void createAutor(Autor autor) { autorRepository.createAutor(autor); }

    @Override
    public void editAutor(Autor autor) { autorRepository.editAutor(autor); }

    @Override
    public void deleteAutor(Long id) { autorRepository.deleteAutor(id); }

    @Override
    public List<Book> getBookByAutor(Long autorId) {
        return autorRepository.getBookByAutor(autorId);
    }

    public Long getNextId() { return autorRepository.getNextId();   }

    public void sort() {autorRepository.sort();
    }
}
