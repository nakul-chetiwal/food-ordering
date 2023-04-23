package com.learning.foodorderservice.model.api.response;

import com.learning.foodorderservice.model.dto.OrderDto;

public class OrderResponse {

	private OrderDto orderDto;

	public OrderDto getOrderDto() {
		return orderDto;
	}

	public void setOrderDto(OrderDto orderDto) {
		this.orderDto = orderDto;
	}

	public OrderResponse() {
	}
	public OrderResponse(OrderDto orderDto) {
		this.orderDto = orderDto;
	}
}
