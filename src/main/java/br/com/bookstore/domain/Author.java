package br.com.bookstore.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Author implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String Name;
	
	// One to Many
	@OneToMany(mappedBy = "BookAuthor")
	private Set<Book> AuthorBooks;
	
	@Override
	public String toString() {
		return "Author [Id=" + Id + ", Name=" + Name + ", AuthorBooks=" + AuthorBooks + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(AuthorBooks, Id, Name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(AuthorBooks, other.AuthorBooks) && Objects.equals(Id, other.Id)
				&& Objects.equals(Name, other.Name);
	}

	public Integer getId() {
		return Id;
	}

	public String getName() {
		return Name;
	}

	public Set<Book> getAuthorBooks() {
		return AuthorBooks;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setAuthorBooks(Set<Book> authorBooks) {
		AuthorBooks = authorBooks;
	}

	
}
