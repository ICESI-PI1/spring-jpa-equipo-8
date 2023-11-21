package com.compunet.bookstore.persistence.dto;

public record AuthorDto(
    Long id,
    String name,
    String nationality
) {
    
}