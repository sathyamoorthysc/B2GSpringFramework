package BtoG.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import BtoG.springframework.spring5webapp.repositories.AuthorRepository;
import BtoG.springframework.spring5webapp.repositories.BookRepository;

@Controller
public class BookController {
	
	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;
	
	public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}
	
	@RequestMapping("/books")
	private String getBooks(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		
		return "books/list";
	}
	
	@RequestMapping("/authors")
	private String getAuthors(Model model) {
		model.addAttribute("authors", authorRepository.findAll());
		
		return "authors/list";
	}
}
