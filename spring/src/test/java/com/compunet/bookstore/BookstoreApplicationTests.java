package com.compunet.bookstore;

import com.compunet.bookstore.persistence.models.Autor;
import com.compunet.bookstore.persistence.models.Book;
import com.compunet.bookstore.persistence.repositories.IAutorRepository;
import com.compunet.bookstore.persistence.repositories.IBookRepository;
import com.compunet.bookstore.services.IAuthorService;
import com.compunet.bookstore.services.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class BookstoreApplicationTests {
	@MockBean
	private IAutorRepository autorRepository;

	@Autowired
	private IAuthorService autorService;

	@MockBean
	private IBookRepository bookRepository;

	@Autowired
	private IBookService bookService;

	@Test
	public void whenGetAllAuthor_thenAuthorListShouldBeReturned() {
		List<Autor> expectedAuthors = Arrays.asList(new Autor(1L, "Autor1", "Nacionalidad1"), new Autor(2L, "Autor2", "Nacionalidad2"));
		when(autorRepository.findAll()).thenReturn(expectedAuthors);

		List<Autor> actualAuthors = autorService.getAllAuthor();

		assertEquals(expectedAuthors, actualAuthors);
	}

	@Test
	public void whenGetDetails_withValidId_thenAuthorShouldBeReturned() {
		Autor expectedAuthor = new Autor(1L, "Autor1", "Nacionalidad1");
		when(autorRepository.findById(1L)).thenReturn(Optional.of(expectedAuthor));

		Optional<Autor> actualAuthor = autorService.getDetails(1L);

		assertTrue(actualAuthor.isPresent());
		assertEquals(expectedAuthor, actualAuthor.get());
	}

	@Test
	public void whenCreateAuthor_thenAuthorShouldBeSaved() {
		Autor newAuthor = new Autor(null, "Nuevo Autor", "Nacionalidad");

		autorService.createAutor(newAuthor);

		verify(autorRepository).save(newAuthor);
	}

	//Book Test

	@Test
	public void whenGetBookByAuthor_withValidAuthorId_thenBookListShouldBeReturned() {
		Autor autor = new Autor(1L, "Autor1", "Nacionalidad1");
		List<Book> expectedBooks = Arrays.asList(new Book(1L, "Libro1", new Date(), autor));
		when(bookRepository.findByAutorId(1L)).thenReturn(expectedBooks);

		List<Book> actualBooks = autorService.getBookByAutor(1L);

		assertEquals(expectedBooks, actualBooks);
	}

	@Test
	public void whenSaveBook_thenBookShouldBeSaved() {
		Book newBook = new Book(null, "Nuevo Libro", new Date(), new Autor(1L, "Autor1", "Nacionalidad1"));

		bookService.save(newBook);

		verify(bookRepository).save(newBook);
	}

	@Test
	public void whenFindById_withValidId_thenBookShouldBeReturned() {
		Book expectedBook = new Book(1L, "Libro1", new Date(), new Autor(1L, "Autor1", "Nacionalidad1"));
		when(bookRepository.findById(1L)).thenReturn(Optional.of(expectedBook));

		Optional<Book> actualBook = bookService.findById(1L);

		assertTrue(actualBook.isPresent());
		assertEquals(expectedBook, actualBook.get());
	}





}
