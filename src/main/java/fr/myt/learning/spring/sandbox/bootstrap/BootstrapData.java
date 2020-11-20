package fr.myt.learning.spring.sandbox.bootstrap;

import fr.myt.learning.spring.sandbox.domain.Author;
import fr.myt.learning.spring.sandbox.domain.Book;
import fr.myt.learning.spring.sandbox.repositories.AuthorRepository;
import fr.myt.learning.spring.sandbox.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
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

    }
}
