package com.compunet.bookstore.persistence.dto.mapper;

import org.springframework.cglib.core.internal.Function;

import com.compunet.bookstore.persistence.dto.AuthorDto;
import com.compunet.bookstore.persistence.models.Author;

public class AuthorDtoMapper implements Function<Author, AuthorDto> {
    @Override
    public AuthorDto apply(Author author) {
        return new AuthorDto(author.getName(), author.getNationality());
    }
    
}
