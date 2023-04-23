package com.learning.foodorderservice.model.api.request;

import com.learning.foodorderservice.model.dto.MenuDto;

public class OrderRequest {

	private MenuDto menu;

	public MenuDto getMenu() {
		return menu;
	}

	public void setMenu(MenuDto menu) {
		this.menu = menu;
	}
	
}
