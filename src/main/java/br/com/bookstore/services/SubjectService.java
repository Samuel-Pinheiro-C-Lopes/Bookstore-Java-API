package br.com.bookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bookstore.domain.Subject;
import br.com.bookstore.repositories.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectRepository SubjectRepo;
	

	// Get
	public Subject FindById(Integer id) {
		return this.SubjectRepo.findById(id).orElseThrow(
				() -> new EntityNotFoundException("Subject with Id: " + id + " was not found."));
	}
	
	public List<Subject> FindAll() {
		return this.SubjectRepo.findAll();
	}
	
	// Post
	public Subject Save(Subject subject) {
		subject.setId(null);
		return this.SubjectRepo.save(subject);
	}
	// Put
	public Subject Upate (Subject subject) {
		Subject dbSubject = this.SubjectRepo.findById(subject.getId()).orElseThrow(() -> new EntityNotFoundException());
		this.SubjectPropertiesUpdate(subject, dbSubject);
		return this.SubjectRepo.save(dbSubject);
	}
	
	// Delete
	public void Delete (Integer id) {
		this.SubjectRepo.deleteById(id);
	}
	
	// Auxiliary Functions
	private void SubjectPropertiesUpdate(Subject getSubject, Subject setSubject) {
		// Note to self: it would be coherent to make this kind of data update
		// be a method of the entities
		setSubject.setName(getSubject.getName());
	}
}
