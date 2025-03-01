package br.com.bookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bookstore.domain.Book;
import br.com.bookstore.repositories.BookRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class BookService {
	
	@Autowired
	private BookRepository BookRepo;
	
	// Get
	public Book FindById(Integer id) {
		return this.BookRepo.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Book with Id: " + id + " was not found."));
	}
	
	public List<Book> FindAll() {
		return this.BookRepo.findAll();
	}
	
	// Post
	public Book Save(Book book) {
		book.setId(null);
		return this.BookRepo.save(book);
	}
	// Put
	public Book Upate (Book book) {
		Book dbBook = this.BookRepo.findById(book.getId()).orElseThrow(() -> new EntityNotFoundException());
		this.BookPropertiesUpdate(book, dbBook);
		return this.BookRepo.save(dbBook);
	}
	
	// Delete
	public void Delete (Integer id) {
		this.BookRepo.deleteById(id);
	}
	
	// Auxiliary Functions
	private void BookPropertiesUpdate(Book getBook, Book setBook) {
		// Note to self: it would be coherent to make this kind of data update
		// be a method of the entities
		setBook.setName(getBook.getName());
		setBook.setPages(getBook.getPages());
		setBook.setPrice(getBook.getPrice());
		setBook.setBookAuthor(getBook.getBookAuthor());
		setBook.setPublicationDate(getBook.getPublicationDate());
		setBook.setBookSubjects(getBook.getBookSubjects());
	}
}
