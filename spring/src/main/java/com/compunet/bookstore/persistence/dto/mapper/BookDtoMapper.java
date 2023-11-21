package com.compunet.bookstore.persistence.dto.mapper;

import org.springframework.cglib.core.internal.Function;

import com.compunet.bookstore.persistence.dto.BookDto;
import com.compunet.bookstore.persistence.models.Book;

public class BookDtoMapper implements Function<Book, BookDto> {
    @Override
    public BookDto apply(Book book) {
        return new BookDto(book.getTitle(), book.getReleaseDate(), book.getAutor());
    }
}
