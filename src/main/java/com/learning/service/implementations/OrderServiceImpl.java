package com.learning.service.implementations;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.convertor.OrderConvertor;
import com.learning.enums.OrderState;
import com.learning.model.dto.OrderDto;
import com.learning.model.entity.OrderEntity;
import com.learning.repository.OrderRepository;
import com.learning.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderConvertor orderConvertor;
	
	@Override
	public OrderDto createOrder(OrderDto orderDto) {
		
		OrderEntity entity = orderConvertor.convert(orderDto);
		entity = orderRepository.save(entity);
		
		OrderDto responseOrderDto = orderConvertor.convertToEntity(entity);
		return responseOrderDto;
	}

	@Override
	public OrderState cancelOrder(Long id) {
		// HINT : find order by id, then update state in db and return OrderState
		return null;
	}

	@Override
	public boolean refundOrder(Long id) {
		// HINT : find order by id, then update state in db and return OrderState
		return false;
	}

	@Override
	public List<OrderDto> orderReports(LocalDate orderDate) {
		
		return null;
	}

	@Override
	public List<OrderDto> orderReports(LocalDate orderDate, OrderState orderState) {

		return null;
	}
	
	
}
