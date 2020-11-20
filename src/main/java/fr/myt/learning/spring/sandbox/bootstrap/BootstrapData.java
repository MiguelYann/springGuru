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

        Book java = new Book("Java effective", "22O");
        Author firstAuthor = new Author("Miguel", "Yann");
        firstAuthor.getBooks().add(java);

        java.getAuthors().add(firstAuthor);
        java.getAuthors().add(firstAuthor);

        authorRepository.save(firstAuthor);
        bookRepository.save(java);

        Author secondAuthor = new Author();
        Book kotlin = new Book("Kotlin Started", "344");

        secondAuthor.getBooks().add(kotlin);
        authorRepository.save(secondAuthor);
        kotlin.getAuthors().add(secondAuthor);

        System.out.println(authorRepository.count());
        System.out.println(bookRepository.count());

        Publisher firstPublisher = new Publisher("12 Rue Verte", "Bordeaux", "France", 33200);
        publisherRepository.save(firstPublisher);

        Publisher secondPublisher = new Publisher("11 Rue Bois", "Bordeaux", "France", 33300);
        publisherRepository.save(secondPublisher);

        System.out.println(publisherRepository.count());
    }
}
