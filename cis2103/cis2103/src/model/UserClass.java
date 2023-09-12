package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class UserClass {
	private String id;
	private String userName;
	private String password;
	private String contact;
	private String role;
	private LocalDateTime userCreated;
	private LocalDateTime userUpdated;
	private String editedByID;
	
	public static final String ADMIN_USER = "ADMIN";
	public static final String REGULAR_USER = "REGULAR";
		
	public UserClass(String id, String userName, String password, String contact, String role) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.contact = contact;
		this.role = role;
	}
	
	public UserClass(String id, String userName, String password, String contact, String role, LocalDateTime userCreated, LocalDateTime userUpdated, String editedByID) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.contact = contact;
		this.role = role;
		this.userCreated = userCreated;
		this.userUpdated = userUpdated;
		this.editedByID = editedByID;
	}
	
	//abstract class
	public abstract String setUserID();
	
	public String getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserCreated() {
		return userCreated.format(DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm a"));
	}

	public void setUserCreated(LocalDateTime userCreated) {
		this.userCreated = userCreated;
	}

	public String getUserUpdated() {
		return userUpdated.format(DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm a"));
	}

	public void setUserUpdated(LocalDateTime userUpdated) {
		this.userUpdated = userUpdated;
	}

	public String getEditedByID() {
		return editedByID;
	}

	public void setEditedBy(String editedByID) {
		this.editedByID = editedByID;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String concatDets() {
		return getId() + " " + getUserName() + " " + getPassword() + " " + getContact() + " " + getRole();
	}
	
	public LocalDateTime getUserUpdatedLDT() {
		return userUpdated;
	}
	
	public LocalDateTime getUserCreatedLDT() {
		return userUpdated;
	}

}
