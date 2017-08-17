package com.spring.library;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by andrzej on 16.08.17.
 */
public interface LibraryRepository extends CrudRepository<Book, Long> {

	List<Book> findByTitle(String title);
}
