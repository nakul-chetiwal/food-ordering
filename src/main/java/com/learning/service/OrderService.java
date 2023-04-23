package com.learning.service;

import java.time.LocalDate;
import java.util.List;


import com.learning.enums.OrderState;
import com.learning.model.dto.OrderDto;
import com.learning.model.dto.OrderStateDto;

public interface OrderService {

	 OrderDto createOrder(OrderDto orderDto);
	
	 OrderStateDto cancelOrder(Long id);
	
	 Boolean refundOrder(Long id);
	
	 List<OrderDto> orderReports(LocalDate orderDate);
	
	 List<OrderDto> orderReports(LocalDate orderDate, OrderState orderState);

}
