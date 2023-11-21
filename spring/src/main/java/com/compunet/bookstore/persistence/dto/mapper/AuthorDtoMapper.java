package com.compunet.bookstore.persistence.dto.mapper;

import java.util.function.Function;

import com.compunet.bookstore.persistence.dto.AuthorDto;
import com.compunet.bookstore.persistence.models.Author;

public class AuthorDtoMapper implements Function<Author, AuthorDto> {
    @Override
    public AuthorDto apply(Author author) {
        return new AuthorDto(author.getId(), author.getName(), author.getNationality());
    }
    
}
