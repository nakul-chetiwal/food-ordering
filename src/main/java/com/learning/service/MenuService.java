package com.learning.service;

import com.learning.enums.FoodType;
import com.learning.model.dto.MenuDto;

public interface MenuService {

	public MenuDto menuListing();
	
	public MenuDto menuListing(FoodType foodType);
	
	public MenuDto addMenu(MenuDto menuDto);
	
	public MenuDto deleteMenu(MenuDto menuDto);
	
}
