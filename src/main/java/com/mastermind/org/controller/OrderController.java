package com.mastermind.org.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastermind.org.playload.Dto.OrderDto;
import com.mastermind.org.service.OrderService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "/api/v1/orders")
public class OrderController {

	private final OrderService orderService ;
	
	public OrderController(OrderService orderService) {
		
		this.orderService = orderService ;
	}
	
	@PostMapping("/add")
	public void addOrder(@RequestBody OrderDto orderDto) {
		this.orderService.addOrder(orderDto);
	}
	
	@GetMapping
	public List<OrderDto> ordersList(){
		return orderService.listOrder();
	}
}
