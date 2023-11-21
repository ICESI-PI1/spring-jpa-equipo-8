package com.compunet.bookstore.services;

import com.compunet.bookstore.persistence.models.Author;
import com.compunet.bookstore.persistence.models.Book;

import java.util.List;
import java.util.Optional;

public interface IAuthorService {
    List<Author> getAllAuthor();
    Optional<Author> getDetails(Long id);
    void createAutor(Author author);
    void editAutor(Author author);
    void deleteAutor(Long id);
    List<Book> getBookByAutor(Long autorId);
}
