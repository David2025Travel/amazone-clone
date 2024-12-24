package com.mastermind.org.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

import com.mastermind.org.entities.Book;
import com.mastermind.org.entities.Category;
import com.mastermind.org.playload.Dto.BookDto;
import com.mastermind.org.repository.BookRepo;
import com.mastermind.org.repository.CategoryRepo;
import com.mastermind.org.service.BookService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookServiceImpl implements BookService {

	private final BookRepo bookRepo ;
	
	private final ModelMapper mapper ;
	
	private final  CategoryRepo categoryRepo ;
	
	public BookServiceImpl(BookRepo bookRepo, ModelMapper mapper, CategoryRepo categoryRepo) {
		
		this.categoryRepo = categoryRepo;
		this.mapper = mapper ;
		this.bookRepo = bookRepo ;
		
		mapping();
		
	}
	
	
	@Override
	public BookDto addBook(BookDto bookDto, String nameCategory) {
		
		Category category = categoryRepo
										.findByName(nameCategory)
										.orElseThrow(
												()-> new EntityNotFoundException("category not found"));
		Book book = mapper.map(bookDto, Book.class);
		
		book.setCategory(category);
		var bookSave = bookRepo.save(book);
		return mapper.map(bookSave, BookDto.class);
	}

	@Override
	public void deleteBook(long idBook) {
		
		bookRepo.deleteById(idBook);
	}

	@Override
	public BookDto updateBook(long idBook, BookDto bookDto) {
		
		
		Book bookSave = bookRepo
								.findById(idBook)
								.orElseThrow(
										()-> new EntityNotFoundException("Book not found"));
		
		bookSave.setAuthor(bookDto.getAuthor());
		
		bookSave.setDescription(bookDto.getDescription());
		
		bookSave.setImagePath(bookDto.getImagePath());
		
		bookSave.setInLinePrice(bookDto.getInLinePrice());
		
		bookSave.setParution(bookDto.getParution());
		
		bookSave.setPrintPrice(bookDto.getPrintPrice());
		
		bookSave.setTotalPages(bookDto.getTotalPages());
		
		bookSave.setSubtitle(bookDto.getSubtitle());
		
		bookSave.setTitle(bookDto.getTitle());
		
		var bookUpdate = bookRepo.save(bookSave);
		return mapper.map(bookUpdate, BookDto.class);
	}

	@Override
	public List<BookDto> listBooks() {
		
		return bookRepo
				.findAll()
				.stream()
				.map(this::convertToDto)
				.toList();
	}
	
	@Override
	public BookDto getBookById(long idBook) {
		
		Book bookSave = bookRepo
				.findById(idBook)
				.orElseThrow(
						()-> new EntityNotFoundException("Book not found"));
		return mapper.map(bookSave, BookDto.class);
	}
	
	private  BookDto convertToDto(Book book) {
		return mapper.map(book, BookDto.class);
	}

	private void mapping() {
		this.mapper.addMappings(new PropertyMap<Book, BookDto>() {
			@Override
			protected void configure() {
				skip(source.getCategory());
				skip(source.getReviews());
				
				map().setNameCategory(source.getCategory().getName());
				
			}
		});
	}
}
