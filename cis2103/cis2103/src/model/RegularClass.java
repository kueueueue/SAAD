package model;

import java.time.LocalDateTime;

public class RegularClass extends UserClass {
	int id;
	public RegularClass(String id, String userName, String password, String contact, String role) {
		super(id, userName, password, contact, UserClass.REGULAR_USER);
		// TODO Auto-generated constructor stub
	}
	
	public RegularClass(String id, String userName, String password, String contact, String role, LocalDateTime userCreated, LocalDateTime userUpdated, String editedByID) {
		super(id, userName, password, contact, UserClass.REGULAR_USER, userCreated, userUpdated, editedByID);
	}

	@Override
	public String setUserID() {
		// TODO Auto-generated method stub
		String id = null;
		if(Database.getUsers() == null) {
			return "R1";
		}
		for(UserClass user: Database.getUsers()) {
			if(user.getRole().equals(UserClass.REGULAR_USER)) {
				id = user.getId();
			}
		}
		return "R" + (Integer.parseInt(id.substring(1))+1);
	}
	
	
	
}

