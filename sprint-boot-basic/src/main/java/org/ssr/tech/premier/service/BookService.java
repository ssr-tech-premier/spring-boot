package org.ssr.tech.premier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssr.tech.premier.datamodels.Book;
import org.ssr.tech.premier.repositories.BookRepository;
import org.ssr.tech.premier.requestmodels.BookCreate;

@Service
public class BookService {
	
	@Autowired
    private BookRepository bookRepo;
	
	public Book createBook(BookCreate book) {
		Book newBook = new Book();
		newBook.setTitle(book.getTitle());
		newBook.setIsbn(book.getIsbn());
		
		return bookRepo.save(newBook); 
	}
	
	public Book fetchBook(Long id) {
		return bookRepo.findOne(id);
	}
	
	public Iterable<Book> fetchBooks() {
		return bookRepo.findAll();
	}
}
