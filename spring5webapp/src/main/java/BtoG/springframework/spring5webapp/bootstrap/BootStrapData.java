package BtoG.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import BtoG.springframework.spring5webapp.domain.Author;
import BtoG.springframework.spring5webapp.domain.Book;
import BtoG.springframework.spring5webapp.domain.Publisher;
import BtoG.springframework.spring5webapp.repositories.AuthorRepository;
import BtoG.springframework.spring5webapp.repositories.BookRepository;
import BtoG.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner{
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository; 
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Publisher publisher = new Publisher();
		publisher.setAddressLine1("S1, Block1, Himalayan town");
		publisher.setCity("Chennai");
		publisher.setName("Publisher Pvt. Ltd.");
		publisher.setState("TN");
		publisher.setZip("600001");
		
		publisherRepository.save(publisher);
		
		Author eric = new Author("Eric", "Evans");
		Book ericBook = new Book("Domain Drive", "123456");
		eric.getBooks().add(ericBook);
		ericBook.getAuthors().add(eric);
		ericBook.setPublisher(publisher);
		publisher.getBooks().add(ericBook);
		
		authorRepository.save(eric);
		bookRepository.save(ericBook);
		publisherRepository.save(publisher);
		
		Author john = new Author("Mathew", "John");
		Book johnBook = new Book("Integris Prolender", "987456");
		john.getBooks().add(johnBook);
		johnBook.getAuthors().add(john);
		johnBook.setPublisher(publisher);
		publisher.getBooks().add(johnBook);
		
		authorRepository.save(john);
		bookRepository.save(johnBook);
		publisherRepository.save(publisher);
		
		System.out.println("Starting in BootStrapData");
		System.out.println("Number of Books: "+bookRepository.count());
		System.out.println("Number of Publishers: "+publisherRepository.count());
		System.out.println("Number of Publisher Books: "+publisher.getBooks().size());
	}

}
