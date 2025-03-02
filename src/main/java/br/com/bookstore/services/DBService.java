package br.com.bookstore.services;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bookstore.domain.Author;
import br.com.bookstore.domain.Book;
import br.com.bookstore.domain.Subject;

@Service
public class DBService {
	
	@Autowired
	private BookService sBook;
	private SubjectService sSubject;
	private AuthorService sAuthor;
	
	public void initializeDataBase () {
		// Subjects
		Subject horror = new Subject("Horror");
		Subject action = new Subject("Action");
		Subject adventure = new Subject("Adventure");
		Subject romance = new Subject("Romance");
		Subject scifi = new Subject("Sci-Fi");
		this.sSubject.Save(horror);
		this.sSubject.Save(adventure);
		this.sSubject.Save(action);
		this.sSubject.Save(romance);
		this.sSubject.Save(scifi);
		
		// Authors
		Author robert = new Author("Robert");
		Author jessica = new Author("Jessica");
		this.sAuthor.Save(jessica);
		this.sAuthor.Save(robert);
		
		// BooksString name, Date publicationDate, Integer pages, Float price) {
		Book hexalibu = new Book("Hexalibu", new Date(0), 10, (float)10.00);
		this.sBook.Save(hexalibu);
	}
}
