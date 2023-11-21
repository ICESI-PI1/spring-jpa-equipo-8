package com.compunet.bookstore.services;

import com.compunet.bookstore.persistence.dto.AuthorDto;
import com.compunet.bookstore.persistence.dto.BookDto;
import com.compunet.bookstore.persistence.models.Author;

import java.util.List;
import java.util.Optional;

public interface IAuthorService {
    List<AuthorDto> getAllAuthor();
    Optional<AuthorDto> getDetails(Long id);
    void createAutor(Author author);
    void editAutor(Author author);
    void deleteAutor(Long id);
    List<BookDto> getBookByAutor(Long autorId);
}
