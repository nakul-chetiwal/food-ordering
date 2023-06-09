package com.learning.foodorderservice.model.dto;

import com.learning.foodorderservice.business.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentResponse {
    private Long id;
    private Long orderId;
    private Double price;
    private LocalDateTime dateTime;
    private PaymentStatus paymentStatus;
    // private List<Transaction> transactionList;
}
