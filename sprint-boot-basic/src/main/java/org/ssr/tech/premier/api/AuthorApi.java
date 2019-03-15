package org.ssr.tech.premier.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ssr.tech.premier.datamodels.Author;
import org.ssr.tech.premier.requestmodels.AuthorCreate;
import org.ssr.tech.premier.service.AuthorService;

@RequestMapping("/authors")
@RestController
public class AuthorApi {
	
	@Autowired
	private AuthorService authorService;
	
	@RequestMapping(method = RequestMethod.POST, produces="application/JSON")
	public ResponseEntity<Author> createAuthor(@RequestBody AuthorCreate author) {
		return new ResponseEntity<Author>(authorService.createAuthor(author),  HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT, produces="application/JSON")
	public ResponseEntity<Author> modifyAuthor() {
		//TODO
		return new ResponseEntity<Author>(new Author(),  HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces="application/JSON")
	public ResponseEntity<Iterable<Author>> fetchAuthors() {
		return new ResponseEntity<Iterable<Author>>(authorService.fetchAuthors(),  HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET, produces="application/JSON")
	public ResponseEntity<Author> fetchAuthor(@PathVariable("id")Long id) {
		return new ResponseEntity<Author>(authorService.fetchAuthor(id),  HttpStatus.OK);
	}

}
