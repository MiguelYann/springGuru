package fr.myt.learning.spring.sandbox.bootstrap;

import fr.myt.learning.spring.sandbox.domain.Author;
import fr.myt.learning.spring.sandbox.domain.Book;
import fr.myt.learning.spring.sandbox.domain.Publisher;
import fr.myt.learning.spring.sandbox.repositories.AuthorRepository;
import fr.myt.learning.spring.sandbox.repositories.BookRepository;
import fr.myt.learning.spring.sandbox.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher firstPublisher = new Publisher("12 Rue Verte", "Bordeaux", "France", 33200);
        publisherRepository.save(firstPublisher);

        Author secondAuthor = new Author("Jen", "Hi");
        Book kotlin = new Book("Kotlin Started", "344");
        secondAuthor.getBooks().add(kotlin);
        kotlin.getAuthors().add(secondAuthor);

        kotlin.setPublisher(firstPublisher);
        firstPublisher.getBooks().add(kotlin);
        authorRepository.save(secondAuthor);
        bookRepository.save(kotlin);


        System.out.println(publisherRepository.count());
    }
}
