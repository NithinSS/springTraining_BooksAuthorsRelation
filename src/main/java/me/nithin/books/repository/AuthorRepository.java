package me.nithin.books.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import me.nithin.books.models.Author;

public interface AuthorRepository<A> extends CrudRepository<Author, Long>{
	List<Author> findByName(String name) ;
}
