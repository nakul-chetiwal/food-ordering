package com.learning.foodorderservice.model.dto;

import java.time.LocalDate;
import java.util.List;

import com.learning.foodorderservice.business.enums.OrderState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

	private Long id;
	private String invoice;
	private LocalDate orderDate;
	private List<String> items;
	private Double totalPrice;
	private OrderState orderState;

}
