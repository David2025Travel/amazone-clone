package com.mastermind.org.service;

import java.util.List;

import com.mastermind.org.playload.Dto.BookDto;

public interface BookService {

	BookDto addBook(BookDto bookDto, String nameCategory);
	
	void deleteBook(long idBook);
	
	BookDto updateBook(long idBook, BookDto bookDto);
	
	BookDto getBookById(long idBook);
	
	List<BookDto> listBooks();
}
