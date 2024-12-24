package com.mastermind.org.playload.Dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderDto {

	private Long id; 

    private String email; 

    private List<OrderItemDto> items; 

    private double totalAmount;  
    
    @JsonProperty(access = Access.READ_ONLY)
    private LocalDateTime orderDate;
}
