package br.com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bookstore.domain.Book;
import br.com.bookstore.services.BookService;

@RestController
@RequestMapping(value = "/book")
public class BookController {
	
	@Autowired
	private BookService sbook;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Book> getBook (@PathVariable Integer Id) {
		Book book = sbook.FindById(Id);
		return ResponseEntity.ok().body(book);
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> getBooks () {
		List<Book> books = sbook.FindAll();
		if (books.isEmpty())
			return ResponseEntity.noContent().build();
		else 
			return ResponseEntity.ok(books);
	}
	
	@PostMapping
	public ResponseEntity<Book> postBook (@RequestBody Book book) {
		Book savedBook = sbook.Save(book);
		return ResponseEntity.ok(savedBook);
	}
	
	@PutMapping
	public ResponseEntity<Book> putBook (@RequestBody Book book) {
		Book updatedBook = sbook.Upate(book);
		return ResponseEntity.ok(updatedBook);
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deleteBook (@PathVariable Integer Id) {
		this.sbook.Delete(Id);
		return ResponseEntity.ok().build();
	}
}
