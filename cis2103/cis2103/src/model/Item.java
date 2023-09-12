package model;

import java.time.LocalDateTime;

public class Item extends Menu{

	
	public Item(String id, String name, float price,  LocalDateTime dateAdded, LocalDateTime dateUpdated, int menuID) {
		super(id, Menu.ITEM_TYPE, name, price, dateAdded, dateUpdated, menuID);
		// TODO Auto-generated constructor stub
	}
	public Item(String id, String name, float price) {
		super(id, Menu.ITEM_TYPE, name, price);
	}

	@Override
	public void updateMenu() {
		// TODO Auto-generated method stub
		
	}
	public String concatDets() {
		return super.getId() + " " + super.getType() + " " + super.getName() + " " + super.getPrice();
	}
	
	

}
