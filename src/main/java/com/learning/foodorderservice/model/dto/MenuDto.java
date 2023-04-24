package com.learning.foodorderservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuDto {

	private List<Snack> snacks;
	private List<MainCourse> mainCourses;
	private List<Drink> drinks;
	

	
	
}
