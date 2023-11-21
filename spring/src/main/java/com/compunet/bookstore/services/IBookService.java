package com.compunet.bookstore.services;

import com.compunet.bookstore.persistence.dto.BookDto;
import com.compunet.bookstore.persistence.models.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    void save(Book book);
    Optional<BookDto> findById(Long id);
    List<BookDto> getAllBook();
    void deleteById(Long id);
    void edit(Book book);
}
