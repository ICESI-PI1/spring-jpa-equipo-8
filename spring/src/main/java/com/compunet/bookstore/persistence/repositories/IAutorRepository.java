package com.compunet.bookstore.persistence.repositories;

import com.compunet.bookstore.persistence.models.Author;
import com.compunet.bookstore.persistence.models.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface IAutorRepository extends CrudRepository <Author, Long> {

    @Query("SELECT a FROM Book a WHERE a.autor.id = :autorId")
    List<Book> getBookByAutor(@Param("autorId") Long autorId);

    @Query("SELECT a FROM Author a ORDER BY a.name ASC")
    List<Author> findAllByOrderByNombreAsc();

}

