package com.compunet.bookstore.persistence.dto.mapper;


import java.util.function.Function;

import com.compunet.bookstore.persistence.dto.BookDto;
import com.compunet.bookstore.persistence.models.Book;

public class BookDtoMapper implements Function<Book, BookDto> {
    @Override
    public BookDto apply(Book book) {
        return new BookDto(book.getId(), book.getTitle(), book.getReleaseDate(), book.getAutor());
    }
}
