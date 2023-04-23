package com.learning.foodorderservice.model.dto;

import com.learning.foodorderservice.business.enums.FoodType;
import com.learning.foodorderservice.business.enums.PlateSize;

public class Dish {
	private Long id;
	private String name;
	private PlateSize plateSize;
	private Double price;
	private FoodType foodType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PlateSize getPlateSize() {
		return plateSize;
	}

	public void setPlateSize(PlateSize plateSize) {
		this.plateSize = plateSize;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public FoodType getFoodType() {
		return foodType;
	}

	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}
}
