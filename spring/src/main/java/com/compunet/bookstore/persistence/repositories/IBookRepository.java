package com.compunet.bookstore.persistence.repositories;

import com.compunet.bookstore.persistence.models.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IBookRepository extends CrudRepository<Book, Long> {
    @Query("SELECT a FROM Book a ORDER BY a.title ASC")
    List<Book> findAllByOrderByTitleAsc();
}
