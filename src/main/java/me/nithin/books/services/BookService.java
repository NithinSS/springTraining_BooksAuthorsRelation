package me.nithin.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.nithin.books.models.Author;
import me.nithin.books.models.Book;
import me.nithin.books.repository.AuthorRepository;
import me.nithin.books.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository<Book> bookRepository ;
	
	@Autowired
	AuthorRepository<Author> authorRepository ;
	
	@Transactional
	public List<Book> getAllBooks() {
		return (List<Book>) bookRepository.findAll() ;
	}
	
	@Transactional
	public List<Book> getByTitle(String title) {
		return (List<Book>) bookRepository.findByTitle(title) ;
	}
	
	@Transactional
	public List<Book> getByGenre(String genre) {
		return (List<Book>) bookRepository.findByGenre(genre) ;
	}
	
	@Transactional
	public boolean addBook(Book book) {
		return bookRepository.save(book) != null ;
	}
	
	@Transactional
	public boolean updateBook(Book book) {
		return bookRepository.save(book) != null ;
	}

	@Transactional
	public Optional<Book> getById(Long id) {
		return bookRepository.findById(id) ;
	}
	
	@Transactional
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	
	@Transactional
	public boolean addAuthor(Long bookId, Long authorId) {
		Optional<Book> book ;
		if((book = bookRepository.findById(bookId)) != null)
		{
			Optional<Author> author ;
			if((author = authorRepository.findById(authorId)) != null)
			{
				author.get().setBooks(book.get());
				authorRepository.save(author.get());
				return true;
			}
			else return false ;
		}
		else return false ;
	}
}
