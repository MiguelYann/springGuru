package fr.myt.learning.spring.sandbox.repositories;

import fr.myt.learning.spring.sandbox.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
