package com.learning.foodorderservice.business.service.implementations;

import com.learning.foodorderservice.business.service.PaymentService;
import com.learning.foodorderservice.clients.PaymentClient;
import com.learning.foodorderservice.model.dto.OrderStateDto;
import com.learning.foodorderservice.business.convertor.OrderConvertor;
import com.learning.foodorderservice.business.enums.OrderState;
import com.learning.foodorderservice.model.dto.OrderDto;
import com.learning.foodorderservice.business.repository.model.OrderEntity;
import com.learning.foodorderservice.business.repository.OrderRepository;
import com.learning.foodorderservice.business.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderConvertor orderConvertor;

    @Autowired
    private PaymentService paymentService;

    @Override
    public OrderDto createOrder(OrderDto orderDto) {

        OrderEntity entity = orderConvertor.convertOrderDtoToOrderEntity(orderDto);
        entity = orderRepository.save(entity);

        OrderDto responseOrderDto = orderConvertor.convertOrderEntityToOrderDto(entity);
        paymentService.makePayment(responseOrderDto);

        return responseOrderDto;
    }

    @Override
    public OrderStateDto cancelOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            return null;
        }
        OrderEntity orderEntity = orderRepository.findById(id).get();
        orderEntity.setOrderState(OrderState.CANCEL);
        OrderEntity orderEntity1 = orderRepository.save(orderEntity);

        return orderConvertor.convertOrderStateToOrderStateDto(orderEntity1.getOrderState());
    }

    @Override
    public Boolean refundOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            return false;
        }
        OrderEntity orderEntity = orderRepository.findById(id).get();
        orderEntity.setOrderState(OrderState.REFUND);
        OrderEntity orderEntity1 = orderRepository.save(orderEntity);
        return true;
    }

    @Override
    public List<OrderDto> orderReports(LocalDate orderDate) {
        List<OrderEntity> orderEntityList = orderRepository.findByOrderDateGreaterThanEqual(orderDate).orElseThrow(() -> new NullPointerException());
        return orderEntityList.stream().map(orderConvertor::convertOrderEntityToOrderDto).collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> orderReports(LocalDate orderDate, OrderState orderState) {
        List<OrderEntity> orderEntityList = orderRepository.findByOrderStateAndOrderDateGreaterThanEqual(
                orderState, orderDate).orElseThrow(() -> new NullPointerException());
        List<OrderDto> orderDtoList = orderEntityList.stream().map(orderConvertor::convertOrderEntityToOrderDto).collect(Collectors.toList());
        return orderDtoList;
    }
}
