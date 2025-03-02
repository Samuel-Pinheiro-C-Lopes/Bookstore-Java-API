package br.com.bookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bookstore.domain.Author;
import br.com.bookstore.repositories.AuthorRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository AuthorRepo;
	
	// Get
	public Author FindById(Integer id) {
		return this.AuthorRepo.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Book with Id: " + id + " was not found."));
	}
	
	public List<Author> FindAll() {
		return this.AuthorRepo.findAll();
	}
	
	// Post
	public Author Save(Author author) {
		author.setId(null);
		return this.AuthorRepo.save(author);
	}
	// Put
	public Author Upate (Author author) {
		Author dbAuthor = this.AuthorRepo.findById(author.getId()).orElseThrow(() -> new EntityNotFoundException());
		this.AuthorPropertiesUpdate(author, dbAuthor);
		return this.AuthorRepo.save(dbAuthor);
	}
	
	// Delete
	public void Delete (Integer id) {
		this.AuthorRepo.deleteById(id);
	}
	
	// Auxiliary Functions
	private void AuthorPropertiesUpdate(Author getAuthor, Author setAuthor) {
		// Note to self: it would be coherent to make this kind of data update
		// be a method of the entities
		setAuthor.setName(getAuthor.getName());
		setAuthor.setAuthorBooks(getAuthor.getAuthorBooks());
	}
}
