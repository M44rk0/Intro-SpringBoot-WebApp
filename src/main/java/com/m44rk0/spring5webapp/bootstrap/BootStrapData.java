package com.m44rk0.spring5webapp.bootstrap;

import com.m44rk0.spring5webapp.model.Author;
import com.m44rk0.spring5webapp.model.Book;
import com.m44rk0.spring5webapp.model.Publisher;
import com.m44rk0.spring5webapp.repositories.AuthorRepository;
import com.m44rk0.spring5webapp.repositories.BookRepository;
import com.m44rk0.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(PublisherRepository publisherRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("Ivo");
        publisher.setAddress("Rua João");
        publisher.setCity("Petersburg");
        publisher.setState("FL");
        publisher.setZip("3434343");

        publisherRepository.save(publisher);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");

        eric.getBooks().add(ddd);
        ddd.getAuthor().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Dev", "12355534");
        rod.getBooks().add(noEJB);
        noEJB.getAuthor().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started!");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Authors: " + authorRepository.toString());
        System.out.println("Books: " + bookRepository.toString());
    }
}
