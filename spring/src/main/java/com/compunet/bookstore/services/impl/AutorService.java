package com.compunet.bookstore.services.impl;

import com.compunet.bookstore.persistence.models.Author;
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
    public List<Author> getAllAuthor() {
        return autorRepository.findAllByOrderByNombreAsc();
    }

    @Override
    public Optional<Author> getDetails(Long id) {
        return autorRepository.findById(id);
    }

    @Override
    public void createAutor(Author author) {
        autorRepository.save(author);
    }

    @Override
    public void editAutor(Author author) {
        autorRepository.save(author);
    }

    @Override
    public void deleteAutor(Long id) {
        autorRepository.deleteById(id);
    }

    @Override
    public List<Book> getBookByAutor(Long autorId) {
        return autorRepository.getBookByAutor(autorId);
    }


}
