package fr.myt.learning.spring.sandbox.repositories;

import fr.myt.learning.spring.sandbox.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
