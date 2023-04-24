package com.learning.foodorderservice.model.dto;

import com.learning.foodorderservice.business.enums.OrderState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderStateDto {
    OrderState orderState;
}
