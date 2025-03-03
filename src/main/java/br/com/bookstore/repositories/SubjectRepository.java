package br.com.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.bookstore.domain.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
