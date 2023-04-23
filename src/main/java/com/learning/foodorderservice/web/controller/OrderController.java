package com.learning.foodorderservice.web.controller;

import com.learning.foodorderservice.model.api.request.OrderRequest;
import com.learning.foodorderservice.model.api.response.OrderResponse;
import com.learning.foodorderservice.model.dto.OrderDto;
import com.learning.foodorderservice.model.dto.OrderStateDto;
import com.learning.foodorderservice.business.enums.OrderState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import com.learning.foodorderservice.business.convertor.OrderConvertor;
import com.learning.foodorderservice.business.service.OrderService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderConvertor orderConvertor;
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
		OrderDto orderDto = orderConvertor.convertOrderRequestToOrderDto(orderRequest);
		orderDto = orderService.createOrder(orderDto);
		OrderResponse orderResponse=new OrderResponse(orderDto);
		return orderResponse;
	}

	@GetMapping("/cancel/{id}")
	public OrderStateDto cancelOrder(@PathVariable Long id){
		OrderStateDto orderStateDto = orderService.cancelOrder(id);
		return orderStateDto;
	}

	@GetMapping("/refund/{id}")
	public Boolean refundOrder(@PathVariable Long id){
		Boolean bool=orderService.refundOrder(id);
		return bool ;
	}

	@GetMapping("/report/{localDate}")
	public List<OrderDto> orderReports(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate localDate){
		return  orderService.orderReports(localDate);
	}

	@GetMapping("/report/{localDate}/{orderState}")
	public List<OrderDto> orderReports(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate localDate,
									   @PathVariable String orderState){
		return orderService.orderReports(localDate, OrderState.valueOf(orderState));
	}
}
