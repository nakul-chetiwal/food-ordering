package com.learning.foodorderservice.business.service;

import com.learning.foodorderservice.clients.PaymentClient;
import com.learning.foodorderservice.model.dto.OrderDto;
import com.learning.foodorderservice.model.dto.PaymentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentService {

    @Autowired
    private PaymentClient paymentClient;

    public PaymentResponse makePayment(OrderDto orderDto) {
        log.info("PaymentService make payment invoke for order id {}", orderDto.getId());
        PaymentClient.PaymentRequest paymentRequest= PaymentClient.PaymentRequest.builder()
                .orderId(orderDto.getId()).price(orderDto.getTotalPrice())
                .build();
        PaymentResponse paymentResponse = paymentClient.makePayment(paymentRequest);
        log.info("Payment done for order id {} and payment ID {} and Payment Status  {}", orderDto.getId(), paymentResponse.getId(), paymentResponse.getPaymentStatus());
        return paymentResponse;
    }

//    public PaymentClient.PaymentDocument getPayment(Long id) {
//        return paymentClient.findPayment(id);
//    }

}
