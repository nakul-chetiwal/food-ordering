package com.learning.foodorderservice.model.api.response;

import com.learning.foodorderservice.model.dto.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

	private OrderDto orderDto;

}
