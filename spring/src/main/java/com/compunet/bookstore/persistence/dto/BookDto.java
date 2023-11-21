package com.compunet.bookstore.persistence.dto;
import java.util.Date;

import com.compunet.bookstore.persistence.models.Author;

public record BookDto(
    String title,
    Date releaseDate,
    Author autor
) {
}