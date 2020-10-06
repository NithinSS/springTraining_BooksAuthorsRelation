package me.nithin.books.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import me.nithin.books.models.Book;
import me.nithin.books.services.BookService;

@RestController
@RequestMapping("/api/v1")
public class BookController {
	
	@Autowired
	BookService bookService ;
	
	@RequestMapping(value="/books", method=RequestMethod.GET)
	public List<Book> getAll() {
		return bookService.getAllBooks() ;
	}
	
	@RequestMapping(value="/book/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<Book> getAllBooks(@PathVariable Long id) {
		return bookService.getById(id) ;
	}
	
	@RequestMapping(value="/bookByTitle/{title}", method=RequestMethod.GET) 
	public List<Book> getBookByTitle(@PathVariable String title) {
		return bookService.getByTitle(title.replace('+', ' ')) ;
	}
	
	@RequestMapping(value="/book", method=RequestMethod.POST)
	public HttpStatus insertBook(@RequestBody Book book) {
		return bookService.addBook(book) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST ;
	}
	
	@RequestMapping(value="/book", method=RequestMethod.PUT)
	public HttpStatus updateBook(@RequestBody Book book) {
		return bookService.updateBook(book) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST ;
	}
	
	@RequestMapping(value="/book/{id}", method=RequestMethod.DELETE)
	public HttpStatus deleteBook(@PathVariable Long id) {
		bookService.deleteBook(id);
		return HttpStatus.NO_CONTENT;
	}
	
	@PutMapping("/book/{bookId}/author/{authorId}")
	public HttpStatus addAuthor(@PathVariable Long bookId, @PathVariable Long authorId ) {
		return bookService.addAuthor(bookId, authorId) ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
	}
	
}
