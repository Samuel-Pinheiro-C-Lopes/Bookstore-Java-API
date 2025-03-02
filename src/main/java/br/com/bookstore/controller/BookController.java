package br.com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
