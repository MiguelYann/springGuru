package fr.myt.learning.spring.sandbox.repositories;

import fr.myt.learning.spring.sandbox.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
