package com.mastermind.org.playload.Dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderDto {

	private Long id; 

    private String email; 

    private List<OrderItemDto> items; 

    private double totalAmount;  

    private String shippingAddress;
}
