package br.com.bookstore.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

@Entity
public class Subject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String Name;
	
	// Many To Many
	@ManyToMany(mappedBy = "BookSubjects")
	private Set<Book> SubjectBooks;
	
	public Subject(String name) {
		super();
		Name = name;
	}

	@Override
	public String toString() {
		return "Subject [Id=" + Id + ", Name=" + Name + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(Id, Name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(Name, other.Name);
	}

	// Getters and Setters
	public Integer getId() {
		return Id;
	}
	public String getName() {
		return Name;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public void setName(String name) {
		Name = name;
	}
	
}
