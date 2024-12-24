package com.mastermind.org.service;

import java.util.List;

import com.mastermind.org.playload.Dto.OrderDto;

public interface OrderService {

	void addOrder(OrderDto orderDto);
	
	List<OrderDto> listOrder();
}
