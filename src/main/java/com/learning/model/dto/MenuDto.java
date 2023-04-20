package com.learning.model.dto;

import java.util.List;

public class MenuDto {

	private List<Snack> snacks;
	private List<MainCourse> mainCourses;
	private List<Drink> drinks;
	
	public List<Snack> getSnacks() {
		return snacks;
	}
	public void setSnacks(List<Snack> snacks) {
		this.snacks = snacks;
	}
	public List<MainCourse> getMainCourses() {
		return mainCourses;
	}
	public void setMainCourses(List<MainCourse> mainCourses) {
		this.mainCourses = mainCourses;
	}
	public List<Drink> getDrinks() {
		return drinks;
	}
	public void setDrinks(List<Drink> drinks) {
		this.drinks = drinks;
	}
	
	
}
