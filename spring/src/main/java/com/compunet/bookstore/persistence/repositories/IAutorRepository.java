package com.compunet.bookstore.persistence.repositories;

import com.compunet.bookstore.persistence.models.Autor;
import com.compunet.bookstore.persistence.models.Book;
import org.springframework.data.repository.CrudRepository;


import java.util.List;
import java.util.Optional;

public interface IAutorRepository extends CrudRepository <Autor, Long> {

    List<Book> getBookByAutor(Long autorId);

}

