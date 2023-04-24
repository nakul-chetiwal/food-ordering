package com.learning.foodorderservice.clients;

import com.learning.foodorderservice.business.enums.PaymentStatus;
import com.learning.foodorderservice.model.dto.PaymentResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-client", url = "http://localhost:8082/api/v1/payment")
public interface PaymentClient {


    @PostMapping
    public PaymentResponse makePayment(@RequestBody PaymentRequest paymentRequest);

    @GetMapping("/{id}")
    public PaymentStatus checkStatus(@PathVariable Long id);

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public class PaymentRequest {
        private Long orderId;
        private Double price;
    }



}
