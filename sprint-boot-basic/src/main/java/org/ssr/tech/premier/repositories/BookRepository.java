package org.ssr.tech.premier.repositories;

import org.springframework.data.repository.CrudRepository;
import org.ssr.tech.premier.datamodels.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	
}
