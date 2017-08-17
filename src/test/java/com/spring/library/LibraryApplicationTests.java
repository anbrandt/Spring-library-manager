package com.spring.library;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryApplicationTests {

	//testowa wersja entity manager
	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private LibraryRepository libraryRepository;

	@Autowired
	private BookService bookService;

	@Before
	public void setUp() {
		bookService = new BookService();

	}


	@Test
	public void createShouldReturnNewBook() {

//		Book testBook = new Book("title", "author", "isbn", "bookCategory");

		String title = "title";
		String author = "author";
		String isbn = "isbn";
		String bookCategory = "bookCategory";


		Book book = bookService.create(title, author, isbn, bookCategory);
		testEntityManager.persist(book);

		Assert.assertEquals(title, book.getTitle());


	}

}
