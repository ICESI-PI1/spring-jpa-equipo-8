package com.compunet.bookstore.services.impl;

import com.compunet.bookstore.persistence.models.Author;
import com.compunet.bookstore.persistence.models.Book;
import com.compunet.bookstore.persistence.repositories.IAuthorRepository;
import com.compunet.bookstore.services.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements IAuthorService {

    @Autowired
    private IAuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAllByOrderByNombreAsc();
    }

    @Override
    public Optional<Author> getDetails(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public void createAutor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void editAutor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void deleteAutor(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<Book> getBookByAutor(Long autorId) {
        return authorRepository.getBookByAutor(autorId);
    }


}
