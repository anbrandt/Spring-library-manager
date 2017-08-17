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


	private BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

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

	//TODO delete should return "deleted"

	@RequestMapping("/library/{title}")
	public Iterable<Book> getByTitle(@PathVariable("title") String title) {
		return bookService.findByTitle(title);
	}

	@RequestMapping("/library/update/{id}")
	public ResponseEntity<Long> update(@PathVariable("id") Long id,  @RequestBody Book book) {

			Book calledBook = new Book(book.getTitle(), book.getAuthor(), book.getIsbn(), book.getBookCategory());
			calledBook.setId(id);

			Book updatedBook = bookService.update(calledBook);

			return new ResponseEntity<>(updatedBook.getId(), HttpStatus.CREATED);
	}





}
