package com.learning.foodorderservice.business.service;

import com.learning.foodorderservice.business.enums.FoodType;
import com.learning.foodorderservice.model.dto.MenuDto;

public interface MenuService {

	public MenuDto menuListing();
	
	public MenuDto menuListing(FoodType foodType);
	
	public MenuDto addMenu(MenuDto menuDto);
	
	public MenuDto deleteMenu(MenuDto menuDto);
	
}
