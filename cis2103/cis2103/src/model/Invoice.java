package model;

import java.sql.SQLException;

public class Invoice {
	int id;
	String paymentMethod;
	String shippingAdd;
	String status;
	int billingID;
	int voucherID;
	int orderID;
	String userID;
	
	public Invoice() {
		try {
			this.id = Database.getLastInvoiceID();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Invoice(String paymentMethod, String shippingAdd, String status, int billingID, int voucherID, int orderID, String userID) {
		this.paymentMethod = paymentMethod;
		this.shippingAdd = shippingAdd;
		this.status = status;
		this.billingID = billingID;
		this.voucherID = voucherID;
		this.orderID = orderID;
		this.userID = userID;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getShippingAdd() {
		return shippingAdd;
	}
	public void setShippingAdd(String shippingAdd) {
		this.shippingAdd = shippingAdd;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getBillingID() {
		return billingID;
	}
	public void setBillingID(int billingID) {
		this.billingID = billingID;
	}
	public int getVoucherID() {
		return voucherID;
	}
	public void setVoucherID(int voucherID) {
		this.voucherID = voucherID;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	
	
}
