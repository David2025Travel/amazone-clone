package com.mastermind.org.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastermind.org.playload.Dto.BookDto;
import com.mastermind.org.service.BookService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "/api/v1/books")
public class BookController {

	private final BookService bookService ;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping
	public List<BookDto> bookList(){
		return bookService.listBooks();
	}
	
	@PostMapping(value = "/{category}")
	
	public ResponseEntity<BookDto> addBook(
			@PathVariable("category") String category,
			@RequestBody BookDto bookDto){
		
		return new ResponseEntity<BookDto>(bookService.addBook(bookDto, category), HttpStatus.CREATED);
	}
}
