package com.compunet.bookstore.persistence.dto;
import java.util.Date;

import com.compunet.bookstore.persistence.models.Author;

public record BookDto(
    Long id,
    String title,
    Date releaseDate,
    Author autor
) {
}