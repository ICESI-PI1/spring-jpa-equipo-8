package com.compunet.bookstore.persistence.repositories;

import com.compunet.bookstore.persistence.models.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IBookRepository extends CrudRepository<Book, Long> {
    List<Book> findByAutorId(Long autorId);
}
