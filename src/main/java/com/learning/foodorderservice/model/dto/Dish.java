package com.learning.foodorderservice.model.dto;

import com.learning.foodorderservice.business.enums.FoodType;
import com.learning.foodorderservice.business.enums.PlateSize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
	private Long id;
	private String name;
	private PlateSize plateSize;
	private Double price;
	private FoodType foodType;


}
