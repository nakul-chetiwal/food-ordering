package com.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.convertor.OrderConvertor;
import com.learning.model.api.request.OrderRequest;
import com.learning.model.api.response.OrderResponse;
import com.learning.model.dto.OrderDto;
import com.learning.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderConvertor orderConvertor;
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
		OrderDto orderDto = orderConvertor.convert(orderRequest);
		orderDto = orderService.createOrder(orderDto);
		return null;
	}

}
