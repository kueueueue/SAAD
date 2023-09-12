package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Feedbacks {
	private int id;
	private String userID;
	private String message;
	private LocalDateTime dateAdded;
	
	public Feedbacks(int id, String userID, String message, LocalDateTime dateAdded) {
		this.id = id;
		this.userID = userID;
		this.message = message;
		this.dateAdded = dateAdded;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDateAdded() {
		return dateAdded.format(DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm a"));
	}
	public void setDateAdded(LocalDateTime dateAdded) {
		this.dateAdded = dateAdded;
	}
}
