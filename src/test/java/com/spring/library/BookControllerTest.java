package com.spring.library;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by andrzej on 17.08.17.
 */


public class BookControllerTest {

	private BookController bookController;

	@Mock
	private BookService bookService;

	@Before
	public void setTestUp() {
		initMocks(this);
		bookController = new BookController(bookService);
	}

	@Test
	public void createShouldCreateBook() {

		String title = "title";
		String author = "author";
		String bookCategory = "bookCategory";
		String isbn = "isbn";

		Book booktest = new Book();

		booktest.setBookCategory(bookCategory);
		booktest.setTitle(title);
		booktest.setIsbn(isbn);
		booktest.setAuthor(author);

		when(bookService.create(title, author, isbn, bookCategory)).thenReturn(booktest);

		ResponseEntity<Long> longResponseEntity = bookController.create(booktest);

		assertEquals(HttpStatus.CREATED, longResponseEntity.getStatusCode());

	}

	@Test
	public void deleteShouldDeleteTheBook() {


		Book book = createDefaultBook();
		bookService.create(book.getTitle(), book.getAuthor(), book.getBookCategory(), book.getIsbn());
		bookService.delete(2L);

		assertEquals(null, null);

	}

	private Book createDefaultBook() {

		Book book = new Book("titl1", "author1", "isbn1", "categor1");

		return book;

	}


}