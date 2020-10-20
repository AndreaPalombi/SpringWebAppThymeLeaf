package port.springframework.webApp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import port.springframework.webApp.model.Author;
import port.springframework.webApp.model.Book;
import port.springframework.webApp.model.Publisher;
import port.springframework.webApp.repositories.AuthorRepository;
import port.springframework.webApp.repositories.BookRepository;
import port.springframework.webApp.repositories.PublisherRepository;

/**
 * Created by Andrea Palombi
 * on 19/10/2020
 */

@Component
public class LoadDatabase implements CommandLineRunner { //JPA injections

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public LoadDatabase(AuthorRepository authorRepository, BookRepository bookRepository,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author murakami = new Author("Murakami", "Haruki");
        Author stephen = new Author("Stephen", "King");
        Author hannah = new Author("Hannah", "Arendt");
        Book kafkaontheshore = new Book("Kafka on the shore", "9780099458326");
        Book theshining = new Book("The shining", "9780743537001");
        Book onviolence = new Book("On violence", "9780156695008");
        Book it = new Book("IT", "9781501142970");
        Publisher penguin = new Publisher("Penguin", "One embassy Gardens, 8", "London", "UK", "SW11 7BW");
        Publisher houghton = new Publisher("Houghton", "La Frontera blvd, 2700", "Round rock", "Texas", "TX 78681");
        Publisher shinchosha = new Publisher("Shinchosha", "Yarai-cho, 71", "Tokyo", "Japan", "162-8711");

        publisherRepository.save(penguin);
        publisherRepository.save(shinchosha);
        publisherRepository.save(houghton);

        murakami.getBooks().add(kafkaontheshore);
        stephen.getBooks().add(theshining);
        hannah.getBooks().add(onviolence);


        kafkaontheshore.getAuthor().add(murakami);
        theshining.getAuthor().add(stephen);
        it.getAuthor().add(stephen);
        onviolence.getAuthor().add(hannah);
        kafkaontheshore.setPublisher(shinchosha);
        it.setPublisher(penguin);
        theshining.setPublisher(penguin);
        onviolence.setPublisher(houghton);


        shinchosha.getBooks().add(kafkaontheshore);
        penguin.getBooks().add(it);
        houghton.getBooks().add(onviolence);
        penguin.getBooks().add(theshining);

        authorRepository.save(murakami);
        authorRepository.save(stephen);
        authorRepository.save(hannah);

        bookRepository.save(kafkaontheshore);
        bookRepository.save(theshining);
        bookRepository.save(onviolence);
        bookRepository.save(it);

        publisherRepository.save(shinchosha);
        publisherRepository.save(houghton);
        publisherRepository.save(penguin);

        System.out.println("Started in bootstrap");
        System.out.println("Number of authors:" + authorRepository.count());
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Penguin publisher Number of books: " + penguin.getBooks().size());
        System.out.println("Houghton publisher Number of books: " + houghton.getBooks().size());
        System.out.println("Shinchosha publisher Number of books: " + shinchosha.getBooks().size());

    }

}

