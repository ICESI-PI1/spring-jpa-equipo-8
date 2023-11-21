package com.compunet.bookstore;

import com.compunet.bookstore.persistence.dto.AuthorDto;
import com.compunet.bookstore.persistence.dto.BookDto;
import com.compunet.bookstore.persistence.models.Author;
import com.compunet.bookstore.persistence.models.Book;
import com.compunet.bookstore.persistence.repositories.IAuthorRepository;
import com.compunet.bookstore.persistence.repositories.IBookRepository;
import com.compunet.bookstore.services.IAuthorService;
import com.compunet.bookstore.services.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookstoreApplicationTests {
	@MockBean
	private IAuthorRepository autorRepository;

	@Autowired
	private IAuthorService autorService;

	@MockBean
	private IBookRepository bookRepository;

	@Autowired
	private IBookService bookService;

	@Test
	public void getAllAuthorsTest() {
		List<Author> expectedAuthors = Arrays.asList(new Author(1L, "Autor1", "Nacionalidad1"), new Author(2L, "Autor2", "Nacionalidad2"));
		when(autorRepository.findAllByOrderByNombreAsc()).thenReturn(expectedAuthors);

		List<AuthorDto> actualAuthors = autorService.getAllAuthor();

		assertEquals(expectedAuthors, actualAuthors);
	}

	@Test
	public void getAuthorDetailsTest() {
		Author expectedAuthor = new Author(1L, "Autor1", "Nacionalidad1");
		when(autorRepository.findById(1L)).thenReturn(Optional.of(expectedAuthor));

		Optional<AuthorDto> actualAuthor = autorService.getDetails(1L);

		assertTrue(actualAuthor.isPresent());
		assertEquals(expectedAuthor, actualAuthor.get());
	}

	@Test
	public void createAuthorTest() {
		Author newAuthor = new Author(5L, "Nuevo Autor", "Nacionalidad");

		autorService.createAutor(newAuthor);

		verify(autorRepository).save(newAuthor);
	}

	@Test
	public void editAuthorTest() {
		Author existingAuthor = new Author(1L, "Autor Original", "Nacionalidad Original");

		autorService.createAutor(existingAuthor);

		Author updatedAuthor = new Author(1L, "Autor Modificado", "Nacionalidad Modificada");
		when(autorRepository.save(updatedAuthor)).thenReturn(updatedAuthor);

		when(autorRepository.findById(1L)).thenReturn(Optional.of(updatedAuthor));

		autorService.editAutor(updatedAuthor);

		verify(autorRepository).save(updatedAuthor);

		AuthorDto author = autorService.getDetails(1L).get();

		assertEquals(updatedAuthor,author);

	}

	@Test
	public void deleteAuthorTest() {
		Author newAuthor = new Author(5L, "Nuevo Autor", "Nacionalidad");

		autorService.createAutor(newAuthor);

		Long authorId = 5L;

		autorService.deleteAutor(authorId);

		verify(autorRepository).deleteById(authorId);

		assertEquals(autorService.getDetails(authorId),Optional.empty());

	}

	@Test
	public void getBookByAuthorTest() {
		Author autor = new Author(1L, "Autor1", "Nacionalidad1");
		List<Book> expectedBooks = Arrays.asList(new Book(1L, "Libro1", new Date(), autor));
		when(autorRepository.getBookByAutor(1L)).thenReturn(expectedBooks);

		List<BookDto> actualBooks = autorService.getBookByAutor(1L);

		assertEquals(expectedBooks, actualBooks);
	}



	@Test
	public void createBooksTest() {
		Book newBook = new Book(null, "Nuevo Libro", new Date(), new Author(1L, "Autor1", "Nacionalidad1"));

		bookService.save(newBook);

		verify(bookRepository).save(newBook);
	}

	@Test
	public void getBookDetailsTest() {
		Book expectedBook = new Book(1L, "Libro1", new Date(), new Author(1L, "Autor1", "Nacionalidad1"));
		when(bookRepository.findById(1L)).thenReturn(Optional.of(expectedBook));

		Optional<BookDto> actualBook = bookService.findById(1L);

		assertTrue(actualBook.isPresent());
		assertEquals(expectedBook, actualBook.get());
	}

	@Test
	public void editBookTest() {
		Book bookToUpdate = new Book(1L, "Libro", new Date(), new Author(1L, "Autor 1", "Nacionalidad 1"));

		bookService.save(bookToUpdate);

		Book updatedBook = new Book(1L, "Libro Actualizado", new Date(), new Author(1L, "Autor 2", "Nacionalidad 2"));
		when(bookRepository.save(updatedBook)).thenReturn(updatedBook);

		when(bookRepository.findById(1L)).thenReturn(Optional.of(updatedBook));

		bookService.edit(updatedBook);

		verify(bookRepository).save(updatedBook);

		BookDto book = bookService.findById(1L).get();

		assertEquals(updatedBook,book);
	}

	@Test
	public void deleteBookTest() {
		Book expectedBook = new Book(5L, "Libro1", new Date(), new Author(1L, "Autor1", "Nacionalidad1"));

		bookService.save(expectedBook);

		Long bookId = 5L;

		bookService.deleteById(bookId);

		verify(bookRepository).deleteById(bookId);

		assertEquals(bookService.findById(bookId),Optional.empty());

	}

	@Test
	public void getAllBooksTest() {
		List<Book> expectedBooks = Arrays.asList(
				new Book(1L, "Libro 1", new Date(), new Author(1L, "Autor 1", "Nacionalidad 1")),
				new Book(2L, "Libro 2", new Date(), new Author(2L, "Autor 2", "Nacionalidad 2"))
		);
		when(bookRepository.findAll()).thenReturn(expectedBooks);

		List<BookDto> actualBooks = bookService.getAllBook();

		assertEquals(expectedBooks, actualBooks);
	}


}