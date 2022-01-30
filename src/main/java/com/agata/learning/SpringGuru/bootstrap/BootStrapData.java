package com.agata.learning.SpringGuru.bootstrap;

import com.agata.learning.SpringGuru.model.Author;
import com.agata.learning.SpringGuru.model.Book;
import com.agata.learning.SpringGuru.model.Publisher;
import com.agata.learning.SpringGuru.repositories.AuthorRepository;
import com.agata.learning.SpringGuru.repositories.BookRepository;
import com.agata.learning.SpringGuru.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("Uno");
        publisher.setCity("Dos");
        publisher.setState("Tres");

        publisherRepository.save(publisher);

        System.out.println("Publisher count: " + publisherRepository.count());

        Author jkRowling = new Author("Jk", "Rowling");
        Book harryPotter = new Book("Harry Potter", "123-456-78");
        jkRowling.getBooks().add(harryPotter);
        harryPotter.getAuthors().add(jkRowling);
        harryPotter.setPublisher(publisher);
        publisher.getBooks().add(harryPotter);

        authorRepository.save(jkRowling);
        bookRepository.save(harryPotter);

        Author eveRodsky = new Author("Eve", "Rodsky");
        Book fairPlay = new Book("Fair Play", "987-654-32");
        eveRodsky.getBooks().add(fairPlay);
        fairPlay.getAuthors().add(eveRodsky);
        fairPlay.setPublisher(publisher);
        publisher.getBooks().add(fairPlay);

        authorRepository.save(eveRodsky);
        bookRepository.save(fairPlay);
        publisherRepository.save(publisher);

        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of books from a publisher: " + publisher.getBooks().size());

    }
}
