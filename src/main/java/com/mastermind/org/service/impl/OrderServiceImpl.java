package com.mastermind.org.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

import com.mastermind.org.entities.Order;
import com.mastermind.org.entities.OrderItem;
import com.mastermind.org.playload.Dto.OrderDto;
import com.mastermind.org.playload.Dto.OrderItemDto;
import com.mastermind.org.repository.BookRepo;
import com.mastermind.org.repository.OrderRepository;
import com.mastermind.org.service.OrderService;

@Service
public class OrderServiceImpl  implements OrderService{

	private final ModelMapper mapper ;
	
	private final OrderRepository orderRepo;
	
	private final BookRepo bookRepo ;
	
	public OrderServiceImpl(ModelMapper mapper, OrderRepository orderRepo, BookRepo bookRepo) {
		
		this.mapper=mapper;
		this.orderRepo = orderRepo;
		this.bookRepo=bookRepo;
		
		mapping();
        
	}
	
	
	@Override
	public void addOrder(OrderDto orderDto) {
		
		
		
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
	
	private void mapping() {
		this.mapper.addMappings(new PropertyMap<Order, OrderDto>() {
            @Override
            protected void configure() {
                map().setEmail(source.getUser().getEmail()); 
            }
        });

        
        this.mapper.addMappings(new PropertyMap<OrderItem, OrderItemDto>() {
            @Override
            protected void configure() {
                map().setIdBook(source.getBook().getId()); 
            }
        });
        
        
        this.mapper.addMappings(new PropertyMap<OrderDto, Order>() {
            @Override
            protected void configure() {
                skip(destination.getUser()); 
                skip(destination.getItems()); 
            }
        });
        
        
        this.mapper.addMappings(new PropertyMap<OrderItemDto, OrderItem>() {
            @Override
            protected void configure() {
                skip(destination.getOrder()); 
                skip(destination.getBook()); 
            }
        });
	}
	
}
