package org.ssr.tech.premier.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssr.tech.premier.datamodels.Author;
import org.ssr.tech.premier.datamodels.Book;
import org.ssr.tech.premier.repositories.AuthorRepository;
import org.ssr.tech.premier.requestmodels.AuthorCreate;

@Service
public class AuthorService {
	
	@Autowired
    private AuthorRepository authorRepo;
	
	@Autowired
	private BookService bookService; 
	
	public Author createAuthor(AuthorCreate author) {
		
		Author newAuthor = new Author();
		newAuthor.setName(author.getName());
		
		if(author.getBookIds() != null && author.getBookIds().size() > 0) {
			List<Book> books = new ArrayList<Book>();
			
			for(Long id : author.getBookIds()) {
				Book book = bookService.fetchBook(id);
				books.add(book);
			}
			
			newAuthor.setBooks(books);
		}
		
		return authorRepo.save(newAuthor);
	}
	
	public Author fetchAuthor(Long id) {
		return authorRepo.findOne(id);
	}
	
	public Iterable<Author> fetchAuthors() {
		return authorRepo.findAll();
	}
	
}
