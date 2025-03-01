package br.com.bookstore.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

@Entity
public class Subject implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String Name;
	
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
