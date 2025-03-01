package br.com.bookstore.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity // Annotated as a entity in the data base
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// Properties
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String Name;
	private Date PublicationDate;
	private Integer Pages;
	private Float Price;
	
	// Many to One
	@ManyToOne
	@JoinColumn(name = "Id_Author")
	private Author BookAuthor;

	// Many to Many
	@ManyToMany
	@JoinTable(
			name = "Book_Subject",
			joinColumns = @JoinColumn(name = "Id_Book"),
			inverseJoinColumns = @JoinColumn(name = "Id_Subject")
	)
	private Set<Subject> BookSubjects;
	
	@Override
	public String toString() {
		return "Book [Id=" + Id + ", Name=" + Name + ", PublicationDate=" + PublicationDate + ", Pages=" + Pages
				+ ", Price=" + Price + ", BookAuthor=" + BookAuthor + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(BookAuthor, Id, Name, Pages, Price, PublicationDate);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(BookAuthor, other.BookAuthor) && Objects.equals(Id, other.Id)
				&& Objects.equals(Name, other.Name) && Objects.equals(Pages, other.Pages)
				&& Objects.equals(Price, other.Price) && Objects.equals(PublicationDate, other.PublicationDate);
	}



	public Integer getId() {
		return Id;
	}

	public String getName() {
		return Name;
	}

	public Date getPublicationDate() {
		return PublicationDate;
	}

	public Integer getPages() {
		return Pages;
	}

	public Float getPrice() {
		return Price;
	}

	public Author getBookAuthor() {
		return BookAuthor;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public void setName(String name) {
		Name = name;
	}

	public void setPublicationDate(Date publicationDate) {
		PublicationDate = publicationDate;
	}

	public void setPages(Integer pages) {
		Pages = pages;
	}

	public void setPrice(Float price) {
		Price = price;
	}

	public void setBookAuthor(Author bookAuthor) {
		BookAuthor = bookAuthor;
	}

}
