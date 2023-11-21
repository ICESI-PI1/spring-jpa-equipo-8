package com.compunet.bookstore.services.impl;

import com.compunet.bookstore.persistence.dto.AuthorDto;
import com.compunet.bookstore.persistence.dto.BookDto;
import com.compunet.bookstore.persistence.dto.mapper.AuthorDtoMapper;
import com.compunet.bookstore.persistence.dto.mapper.BookDtoMapper;
import com.compunet.bookstore.persistence.models.Author;
import com.compunet.bookstore.persistence.repositories.IAuthorRepository;
import com.compunet.bookstore.services.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements IAuthorService {
    private AuthorDtoMapper authorDtoMapper = new AuthorDtoMapper();
    private BookDtoMapper bookDtoMapper = new BookDtoMapper();

    @Autowired
    private IAuthorRepository authorRepository;

    @Override
    public List<AuthorDto> getAllAuthor() {
        return authorRepository.findAllByOrderByNombreAsc().stream().map(authorDtoMapper).toList();
    }

    @Override
    public Optional<AuthorDto> getDetails(Long id) {
        return authorRepository.findById(id).stream().map(authorDtoMapper).findFirst();
    }

    @Override
    public void createAutor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void editAutor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void deleteAutor(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<BookDto> getBookByAutor(Long autorId) {
        return authorRepository.getBookByAutor(autorId).stream().map(bookDtoMapper).toList();
    }


}
