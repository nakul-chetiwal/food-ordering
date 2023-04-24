package com.learning.foodorderservice.model.dto;

import com.learning.foodorderservice.business.enums.DrinkSize;
import com.learning.foodorderservice.business.enums.DrinkType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Drink {

	private Long id;
	private String name;
	private DrinkType drinkType;
	private DrinkSize drinkSize;
	private Double price;

	
	
}
