package model;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class Menu {
	private String id;
	private String type;
	private String name;
	private double price;
	private int quantity;
	private LocalDateTime dateAdded;
	private LocalDateTime dateUpdated;
	private int menuID;
	
//	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	public static final String PACKAGE_TYPE = "Package";
	public static final String ITEM_TYPE = "Item";

	public Menu(String id, String type, String name, float price, LocalDateTime dateAdded, LocalDateTime dateUpdated, int menuID) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.price = price;
		this.dateAdded = dateAdded;
		this.dateUpdated = dateUpdated;
		this.menuID = menuID;
	}
	
	public Menu(String id, String type, String name, float price) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.price = price;
		this.dateAdded = LocalDateTime.now();
		this.dateUpdated = LocalDateTime.now();
	}

	public int getMenuID() {
		return menuID;
	}

	public void setMenuID(int menuID) {
		this.menuID = menuID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}
	

	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	public String getDateAdded() {
		return dateAdded.format(DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm a"));
	}

	public void setDateAdded(LocalDateTime dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getDateUpdated() {
		return dateUpdated.format(DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm a"));
	}

	public void setDateUpdated(LocalDateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	
	public LocalDateTime getDateAddedLDT() {
		return dateAdded;
	}

	public void setDateAddedLDT(LocalDateTime dateAdded) {
		this.dateAdded = dateAdded;
	}

	public LocalDateTime getDateUpdatedLDT() {
		return dateUpdated;
	}

	public void setDateUpdatedLDT(LocalDateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	
	public abstract String concatDets();
	
	public abstract void updateMenu();

	
}
