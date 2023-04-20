package com.learning.model.dto;

import com.learning.enums.DrinkSize;
import com.learning.enums.DrinkType;

public class Drink {

	private Long id;
	private String name;
	private DrinkType drinkType;
	private DrinkSize drinkSize;
	private Double price;
	
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
	public DrinkType getDrinkType() {
		return drinkType;
	}
	public void setDrinkType(DrinkType drinkType) {
		this.drinkType = drinkType;
	}
	public DrinkSize getDrinkSize() {
		return drinkSize;
	}
	public void setDrinkSize(DrinkSize drinkSize) {
		this.drinkSize = drinkSize;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
