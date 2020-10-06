package me.nithin.books.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.nithin.books.repository.AuthorRepository;
import me.nithin.books.models.Author;
import me.nithin.books.models.Book;

@Service
public class AuthorService {
	@Autowired
	private AuthorRepository<Author> authorRepository ;
	
	@Transactional
	public List<Author> getAllAuthors() {
		return (List<Author>) authorRepository.findAll() ;
	}
	
	@Transactional
	public boolean addAuthor(Author author) {
		return authorRepository.save(author) != null ;
	}
	
	@Transactional 
	public Optional<Author> getById(Long id) {
		return authorRepository.findById(id) ;
	}
	
	@Transactional
	public List<Author> getByName(String name) {
		List<Author> authors = new ArrayList<Author>() ;
		authors = authorRepository.findByNameContaining(name) ;
		return authors;
	}
	
	@Transactional 
	public List<String> getBooksByAuthorId(Long id) {
		List<String> books = new ArrayList<String>();
		Optional<Author> author = authorRepository.findById(id) ;
		if(author.isEmpty()) return null;
		else {
			for (Book book : author.get().getBooks()) {
				books.add(book.getTitle()) ;
			}
		}
		return books;
	}
	
	@Transactional
	public void deleteAuthor(Long id) {
		authorRepository.deleteById(id);
	}
}
