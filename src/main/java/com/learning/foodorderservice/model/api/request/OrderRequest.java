package com.learning.foodorderservice.model.api.request;

import com.learning.foodorderservice.model.dto.MenuDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

	private MenuDto menu;

	
}
