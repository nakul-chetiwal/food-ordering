package com.learning.service;

import java.time.LocalDate;
import java.util.List;

import com.learning.enums.OrderState;
import com.learning.model.dto.OrderDto;

public interface OrderService {

	public OrderDto createOrder(OrderDto orderDto);
	
	public OrderState cancelOrder(Long id);
	
	public boolean refundOrder(Long id);
	
	public List<OrderDto> orderReports(LocalDate orderDate);
	
	public List<OrderDto> orderReports(LocalDate orderDate, OrderState orderState);

}
