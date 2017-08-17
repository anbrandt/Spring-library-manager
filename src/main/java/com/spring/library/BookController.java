package com.spring.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by andrzej on 16.08.17.
 */

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping("/library")
	public String libraryStart() {
		return "Library started";
	}

	@RequestMapping("/library/create")
	public ResponseEntity<Long> create (@RequestBody Book book) {
		Book book1 = bookService.create(book.getTitle(), book.getAuthor(), book.getIsbn(), book.getBookCategory());
		return new ResponseEntity<>(book1.getId(), HttpStatus.CREATED);
	}

	@RequestMapping("/library/all")
	public Iterable<Book> getAll() {
		return bookService.getAllBooks();
	}

	@RequestMapping("/library/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		bookService.delete(id);
	}

	@RequestMapping("/library/{title}")
	public Iterable<Book> getByTitle(@PathVariable("title") String title) {
		return bookService.findByTitle(title);
	}

	/*@RequestMapping("/library/update/{id}")
	public Book update(@PathVariable ("id") @RequestBody Book book) {
			bookService.update(book.setAuthor(), book.setTitle(), book.setBookCategory(););

	}*/





}
