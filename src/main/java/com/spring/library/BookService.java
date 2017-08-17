package com.spring.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by andrzej on 16.08.17.
 */

@Service
public class BookService {


	@Autowired
	private LibraryRepository libraryRepository;

	//CRUD here
	//ctrl shift t = create new class test

	public Book create(String title, String author, String isbn, String bookCategory) {
		Book book = new Book(title, author, isbn, bookCategory);

		return libraryRepository.save(book);
	}

	public void delete (long id) {
		libraryRepository.delete(id);
	}


	public Book update (Book book) {
		return libraryRepository.save(book);
	}

	public Iterable<Book> findByTitle(String title) {
		return libraryRepository.findByTitle(title);
	}

	public Iterable<Book> getAllBooks() {
		return libraryRepository.findAll();
	}

}
