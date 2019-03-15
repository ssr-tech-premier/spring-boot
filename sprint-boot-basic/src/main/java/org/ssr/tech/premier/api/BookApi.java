package org.ssr.tech.premier.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.ssr.tech.premier.datamodels.Book;
import org.ssr.tech.premier.requestmodels.BookCreate;
import org.ssr.tech.premier.service.BookService;

@RequestMapping("/books")
@RestController
public class BookApi {
	
	@Autowired
	private BookService bookService; 
	
	@RequestMapping(method = RequestMethod.POST, produces="application/JSON")
	public ResponseEntity<Book> createBook(@RequestBody BookCreate book) {
		return new ResponseEntity<Book>(bookService.createBook(book),  HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT, produces="application/JSON")
	public ResponseEntity<Book> modifyBook() {
		//TODO
		return new ResponseEntity<Book>(new Book(),  HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces="application/JSON")
	public ResponseEntity<Iterable<Book>> fetchBooks() {
		return new ResponseEntity<Iterable<Book>>(bookService.fetchBooks(),  HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET, produces="application/JSON")
	public ResponseEntity<Book> fetchBook(@PathVariable("id") Long id) {
		return new ResponseEntity<Book>(bookService.fetchBook(id),  HttpStatus.OK);
	}
	
}
