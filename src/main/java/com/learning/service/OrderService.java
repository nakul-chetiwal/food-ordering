package com.learning.service;

import java.time.LocalDate;
import java.util.List;


import com.learning.model.dto.OrderDto;
import com.learning.model.dto.OrderStateDto;

public interface OrderService {

	public OrderDto createOrder(OrderDto orderDto);
	
	public OrderStateDto cancelOrder(Long id);
	
	public Boolean refundOrder(Long id);
	
	public List<OrderDto> orderReports(LocalDate orderDate);
	
	public List<OrderDto> orderReports(LocalDate orderDate, String orderState);

}
