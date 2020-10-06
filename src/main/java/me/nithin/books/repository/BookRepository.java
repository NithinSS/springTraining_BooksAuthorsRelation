package me.nithin.books.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import me.nithin.books.models.Book;

public interface BookRepository<B> extends CrudRepository<Book, Long> {
	List<Book> findByTitleContaining(String title) ;
	List<Book> findByGenre(String genre) ;
}
