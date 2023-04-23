package com.learning.foodorderservice.business.service;

import java.time.LocalDate;
import java.util.List;


import com.learning.foodorderservice.model.dto.OrderDto;
import com.learning.foodorderservice.model.dto.OrderStateDto;
import com.learning.foodorderservice.business.enums.OrderState;

public interface OrderService {

	 OrderDto createOrder(OrderDto orderDto);
	
	 OrderStateDto cancelOrder(Long id);
	
	 Boolean refundOrder(Long id);
	
	 List<OrderDto> orderReports(LocalDate orderDate);
	
	 List<OrderDto> orderReports(LocalDate orderDate, OrderState orderState);

}
