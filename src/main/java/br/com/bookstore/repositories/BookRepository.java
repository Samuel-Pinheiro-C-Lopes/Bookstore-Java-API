package br.com.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.bookstore.domain.Book;

// Data Access Object
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
