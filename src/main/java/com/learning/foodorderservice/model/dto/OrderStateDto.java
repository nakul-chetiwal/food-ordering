package com.learning.foodorderservice.model.dto;

import com.learning.foodorderservice.business.enums.OrderState;

public class OrderStateDto {
    OrderState orderState;

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }
}
