package br.com.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.bookstore.domain.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{

}
