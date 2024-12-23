package com.mastermind.org.playload.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderItemDto {

	private Long id; 

    private Long idBook; 

    private int quantity; 

    private double unitPrice; 

    private double totalPrice;
}
