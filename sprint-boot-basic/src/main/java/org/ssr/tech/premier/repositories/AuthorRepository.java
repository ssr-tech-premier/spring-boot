package org.ssr.tech.premier.repositories;

import org.springframework.data.repository.CrudRepository;
import org.ssr.tech.premier.datamodels.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}