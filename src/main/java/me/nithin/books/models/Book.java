package me.nithin.books.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable=false)
	private String title;
	private String genre;
	private float rating;
	
	@ManyToMany(mappedBy = "books", cascade = { CascadeType.ALL})
	private List<Author> authors = new ArrayList<Author>();
	
	public Book() {
		
	}
	
	public Book(String title) {
		this.title = title ;
	}
	
	public long getId() {
		return this.id ;
	}
	
	public void setId(Long id) {
		this.id = id ;
	}
	
	public void setAuthors(Author author) {
		this.authors.add(author) ;
	}
	
	public List<Author> getAuthors() {
		return this.authors;
	}
	
	public void setTitle(String title) {
		this.title = title ;
	}
	
	public String getTitle() {
		return this.title ;
	}
	
	public void setGenre(String genre) {
		this.genre = genre ;
	}
	
	public String getGenre() {
		return this.genre ;
	}
	
	public void setRating(float rating) {
		this.rating = rating ;
	}
	
	public float getRating() {
		return this.rating ;
	}
}
