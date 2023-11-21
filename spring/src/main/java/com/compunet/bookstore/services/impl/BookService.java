package com.compunet.bookstore.services.impl;

import com.compunet.bookstore.persistence.models.Book;
import com.compunet.bookstore.persistence.repositories.IBookRepository;
import com.compunet.bookstore.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public String toString() {
        return ("BookService (repo:" + bookRepository.toString() + ")");
    }

    @Override
    public void edit(Book book){
        bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAllByOrderByTitleAsc();
    }
}
