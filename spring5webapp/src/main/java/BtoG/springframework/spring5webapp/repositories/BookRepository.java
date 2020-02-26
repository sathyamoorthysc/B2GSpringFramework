package BtoG.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import BtoG.springframework.spring5webapp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
