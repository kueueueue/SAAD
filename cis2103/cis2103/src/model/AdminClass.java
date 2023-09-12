package model;

import java.time.LocalDateTime;

public class AdminClass extends UserClass {
	
	public AdminClass(String id, String userName, String password, String contact, String role) {
		super(id, userName, password, contact, UserClass.ADMIN_USER);
		// TODO Auto-generated constructor stub
	}

	public AdminClass(String id, String userName, String password, String contact, String role, LocalDateTime userCreated, LocalDateTime userUpdated, String editedByID) {
		super(id, userName, password, contact, UserClass.ADMIN_USER, userCreated, userUpdated, editedByID);
	}
	
	@Override
	public String setUserID() {
		// TODO Auto-generated method stub
		String id = null;
		if(Database.getUsers() == null) {
			return "A1";
		}
		for(UserClass user: Database.getUsers()) {
			if(user.getRole().equals(UserClass.ADMIN_USER)) {
				id = user.getId();
			}
		}
		return "A" + (Integer.parseInt(id.substring(1))+1);
	}
}
