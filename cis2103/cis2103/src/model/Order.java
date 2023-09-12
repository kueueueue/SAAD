package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class Order {
	private int id;
	private String orderMethod;
	private String deliveryMethod;
	private float total;
	
	private ArrayList<Menu> menuOrders;
	
	public static String PHYSICAL = "Physical";
	public static String ONLINE = "Online";
	public static String PICKUP = "Pickup";
	public static String DELIVER = "Deliver";
	
	
	public Order() throws SQLException {
		this.id = Database.getLastOrderID();
		this.orderMethod = PHYSICAL;
		this.deliveryMethod = PICKUP;
		menuOrders = new ArrayList<Menu>();
	}
//	
//	public Order(float total, ArrayList<Menu> menuOrders) throws SQLException {
//		this.id = Database.getLastOrderID();
//		this.orderMethod = PHYSICAL;
//		this.deliveryMethod = PICKUP;
//		this.total = total;
//		this.menuOrders = menuOrders;
//	}
	
	public Order(int id, String orderMethod, String deliveryMethod, float total, ArrayList<Menu> menuOrders) {
		this.id = id;
		this.orderMethod = orderMethod;
		this.deliveryMethod = deliveryMethod;
		this.total = total;
		this.menuOrders = menuOrders;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderMethod() {
		return orderMethod;
	}
	public void setOrderMethod(String orderMethod) {
		this.orderMethod = orderMethod;
	}
	public String getDeliveryMethod() {
		return deliveryMethod;
	}
	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public ArrayList<Menu> getMenuOrders() {
		return menuOrders;
	}
	public void setMenuOrders(ArrayList<Menu> menuOrders) {
		this.menuOrders = menuOrders;
	}

	
}
