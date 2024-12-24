package com.mastermind.org.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

import com.mastermind.org.entities.Book;
import com.mastermind.org.entities.Order;
import com.mastermind.org.entities.OrderItem;
import com.mastermind.org.entities.User;
import com.mastermind.org.playload.Dto.OrderDto;
import com.mastermind.org.playload.Dto.OrderItemDto;
import com.mastermind.org.repository.BookRepo;
import com.mastermind.org.repository.ClientRepo;
import com.mastermind.org.repository.OrderRepository;
import com.mastermind.org.service.OrderService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderServiceImpl  implements OrderService{

	private final ModelMapper mapper ;
	
	private final OrderRepository orderRepo;
	
	private final BookRepo bookRepo ;
	
	private final ClientRepo clientRepo ;
	
	public OrderServiceImpl(
			ModelMapper mapper, 
			OrderRepository orderRepo, 
			BookRepo bookRepo,
			ClientRepo clientRepo) {
		
		this.clientRepo = clientRepo ;
		this.mapper=mapper;
		this.orderRepo = orderRepo;
		this.bookRepo=bookRepo;
		
		
        
	}
	
	
	@Override
	public void addOrder(OrderDto orderDto) {
		
		Order order = mapper.map(orderDto, Order.class);

        
        User user = clientRepo.findByEmail(orderDto.getEmail())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        order.setUser(user);

        
        List<OrderItem> items = orderDto.getItems().stream()
                .map(this::convertItemToEntity)
                .peek(item -> item.setOrder(order))
                .collect(Collectors.toList());
        
        order.setItems(items);
        
        orderRepo.save(order);
		
	}
	
	private OrderItem convertItemToEntity(OrderItemDto orderItemDto) {
		
        OrderItem orderItem = mapper.map(orderItemDto, OrderItem.class);

        
        Book book = bookRepo.findById(orderItemDto.getIdBook())
                .orElseThrow(() -> new EntityNotFoundException("Book not found"));
        
        if((book.getQuantity()-orderItem.getQuantity())<0)
        	throw new  RuntimeException("Stock insuffisant");
        
        book.setQuantity(book.getQuantity()-orderItem.getQuantity());
        bookRepo.save(book);
        orderItem.setBook(book);

        return orderItem;
    }
	
	@Override
	public List<OrderDto> listOrder() {
		
		return orderRepo
						.findAll()
						.stream()
						.map(this::convertToDto)
						.toList();
	}
	
	private OrderDto convertToDto(Order order) {
		
		return this.mapper.map(order, OrderDto.class);
	}
	
	
	
}
