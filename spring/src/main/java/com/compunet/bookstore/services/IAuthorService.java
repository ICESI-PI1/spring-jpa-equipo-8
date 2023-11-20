package com.compunet.bookstore.services;

import com.compunet.bookstore.persistence.models.Autor;
import com.compunet.bookstore.persistence.models.Book;

import java.util.List;
import java.util.Optional;

public interface IAuthorService {
    List<Autor> getAllAuthor();
    Optional<Autor> getDetails(Long id);
    void createAutor(Autor autor);
    void editAutor(Autor autor);
    void deleteAutor(Long id);
    List<Book> getBookByAutor(Long autorId);
}
