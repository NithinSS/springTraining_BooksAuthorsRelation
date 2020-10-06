package me.nithin.books.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Author {
	
	@Id
	@GeneratedValue
	private long id ;
	
	@Column(nullable=false)
	private String name ;
	
	
	@JsonIgnore
	@ManyToMany(cascade= {CascadeType.ALL})
	@JoinTable(
			name="WrittenBy",
			joinColumns=@JoinColumn(name="author_id", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="book_id", referencedColumnName="id"))
	private List<Book> books = new ArrayList<Book>() ;
	
	public Author() {
		
	}
	
	public Author(String name) {
		this.name = name ;
	}
	
	public Long getId() {
		return this.id ;
	}
	
	public void setId(Long id) {
		this.id = id ;
	}
	
	public List<Book> getBooks() {
		return this.books;
	}
	
	public void setBooks(Book book) {
		this.books.add(book);
	}
	
	public String getName() {
		return this.name ;
	}
	
	public void setName(String name) {
		this.name = name ;
	}
	
}
