package me.nithin.books.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import me.nithin.books.models.Author;
import me.nithin.books.services.AuthorService;

@RestController
@RequestMapping("/api/v1")
public class AuthorController {
	
	@Autowired
	AuthorService authorService;
	
	@RequestMapping(value="/authors", method=RequestMethod.GET)
	public List<Author> getAll() {
		return authorService.getAllAuthors() ;
	}
	
	@RequestMapping(value="/author", method=RequestMethod.POST)
	public HttpStatus insertAuthor(@RequestBody Author author) {
		return authorService.addAuthor(author) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST ;
	}
	
	@RequestMapping(value="/author/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<Author> getAuthor(@PathVariable Long id) {
		return authorService.getById(id) ;
	}
	
	@GetMapping("/authorByName/{name}")
	public @ResponseBody List<Author> getAuthorByName(@PathVariable String name) {
		return authorService.getByName(name.replace('+', ' ')) ;
	}
	
	@GetMapping("/booksByAuthor/{id}")
	public @ResponseBody List<String> getBooksByAuthorId(@PathVariable Long id) {
		return authorService.getBooksByAuthorId(id);
	}
	
	@DeleteMapping("/author/{id}")
	public HttpStatus deleteAuthor(@PathVariable Long id) {
		authorService.deleteAuthor(id) ;
		return HttpStatus.NO_CONTENT ;
	}
	
}
