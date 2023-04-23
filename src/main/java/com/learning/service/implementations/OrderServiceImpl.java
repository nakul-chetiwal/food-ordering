package com.learning.service.implementations;

import com.learning.convertor.OrderConvertor;
import com.learning.enums.OrderState;
import com.learning.model.dto.OrderDto;
import com.learning.model.dto.OrderStateDto;
import com.learning.model.entity.OrderEntity;
import com.learning.repository.OrderRepository;
import com.learning.service.OrderService;
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

    @Override
    public OrderDto createOrder(OrderDto orderDto) {

        OrderEntity entity = orderConvertor.convertOrderDtoToOrderEntity(orderDto);
        entity = orderRepository.save(entity);

        OrderDto responseOrderDto = orderConvertor.convertOrderEntityToOrderDto(entity);
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
        List<OrderEntity> orderEntityList=  orderRepository.findByOrderDateGreaterThanEqual(orderDate).orElseThrow(() ->new NullPointerException());
        return  orderEntityList.stream().map(orderConvertor::convertOrderEntityToOrderDto).collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> orderReports(LocalDate orderDate, String orderState) {
        List<OrderEntity> orderEntityList= orderRepository.findByOrderStateAndOrderDate(orderDate,OrderState.valueOf(orderState)).orElseThrow(() ->new NullPointerException());
        return null;
    }
}
