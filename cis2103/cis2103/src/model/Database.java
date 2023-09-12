package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;


import exceptions.MenuNotFoundException;
import exceptions.NameExistsInArrayException;
import exceptions.UserNotFoundException;

public class Database {
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	
	private static ArrayList<UserClass> users = new ArrayList<UserClass>();
	private static ArrayList<Menu> menu = new ArrayList<Menu>();
	private static ArrayList<Item> items = new ArrayList<Item>();
	private static ArrayList<Package> pack = new ArrayList<Package>();
	private static ArrayList<Order> orders = new ArrayList<Order>();
	private static ArrayList<Feedbacks> feedback = new ArrayList<Feedbacks>();
	private static ArrayList<Invoice> invoice = new ArrayList<Invoice>();

	public Database () throws SQLException {
		conn = null;
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cis2103", "root", "");
        
	}
	
	//Getters and setters
	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	public Statement getSt() {
		return st;
	}

	public void setSt(Statement st) {
		this.st = st;
	}

	public PreparedStatement getPst() {
		return pst;
	}

	public void setPst(String string) throws SQLException {
		this.pst = conn.prepareStatement(string);
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs() throws SQLException {
		this.rs = this.pst.executeQuery();
	}

	public void closeConn() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ResultSet executeStatement(String string) throws SQLException {
		this.st = conn.createStatement();
		this.rs = st.executeQuery(string);
		return rs;
	}
	
	
///////////////////////////////////////////////////////////////////////////////////
/////////static ArrayList getters and setters//////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////
	public static ArrayList<UserClass> getUsers() {
		return users;
	}

	public static void setUsers(ArrayList<UserClass> users) {
		Database.users = users;
	}

	public static ArrayList<Menu> getMenu() {
		return menu;
	}

	public static void setMenu(ArrayList<Menu> menu) {
		Database.menu = menu;
	}

	public static ArrayList<Item> getItems() {
		return items;
	}

	public static void setItems(ArrayList<Item> items) {
		Database.items = items;
	}

	public static ArrayList<Package> getPack() {
		return pack;
	}

	public static void setPack(ArrayList<Package> pack) {
		Database.pack = pack;
	}

	public static ArrayList<Order> getOrders() {
		return orders;
	}

	public static void setOrders(ArrayList<Order> orders) {
		Database.orders = orders;
	}

	public static ArrayList<Feedbacks> getFeedback() {
		return feedback;
	}

	public static void setFeedback(ArrayList<Feedbacks> feedback) {
		Database.feedback = feedback;
	}

	public static ArrayList<Invoice> getInvoice() {
		return invoice;
	}

	public static void setInvoice(ArrayList<Invoice> invoice) {
		Database.invoice = invoice;
	}
	
/////////////////////////////////////////////////////////////////////////////
//////////////LOAD TABLES FROM DATABASE//////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
	public static void loadUsersFromDatabase() throws SQLException {
	    Database db = null;
	    UserClass user = null;
	    users.clear();
	    try {
	        db = new Database();
	        ResultSet rs = db.executeStatement("SELECT * FROM user");
	        while (rs.next()) {
	            String id = rs.getString("userID");
	            String userName = rs.getString("name");
	            String password = rs.getString("password");
	            String contact = rs.getString("contactNo");
	            String role = rs.getString("role");
	            Timestamp userCreated = rs.getTimestamp("userCreated");
	            Timestamp userUpdated = rs.getTimestamp("userUpdated");
	            String editedByID = rs.getString("editorID");
	            if(role.equals(UserClass.ADMIN_USER)) {
				    user = new AdminClass(id, userName, password, contact, role, userCreated.toLocalDateTime(), userUpdated.toLocalDateTime(), editedByID);    
				}
				if(role.equals(UserClass.REGULAR_USER)) {
					user = new RegularClass(id, userName, password, contact, role, userCreated.toLocalDateTime(), userUpdated.toLocalDateTime(), editedByID);
				}
	            users.add(user);
	        }
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
	
	public static void loadMenuFromDatabase() throws SQLException {
		Database db = null;
	    menu.clear();
	    try {
	        db = new Database();
	        ResultSet rs = db.executeStatement("SELECT COALESCE(package.packageID, items.itemID) AS id,\r\n"
	        		+ "menu.menuType AS type,\r\n"
	        		+ "COALESCE(package.name, items.name) AS name,\r\n"
	        		+ "COALESCE(package.price, items.price) AS price,\r\n"
	        		+ "COALESCE(package.dateAdded, items.dateAdded) AS dateAdded,\r\n"
	        		+ "COALESCE(package.dateUpdated, items.dateUpdated) AS dateUpdated,\r\n"
	        		+ "menu.menuID\r\n"
	        		+ "FROM menu\r\n"
	        		+ "LEFT JOIN package ON menu.menuID = package.menuID\r\n"
	        		+ "LEFT JOIN items ON menu.menuID = items.menuID;");
	        while (rs.next()) {
	            String id = rs.getString("id");
	            String type = rs.getString("type");
	            String name = rs.getString("name");
	            float price = rs.getFloat("price");
	            Timestamp dateAdded = rs.getTimestamp("dateAdded");
	            Timestamp dateUpdated = rs.getTimestamp("dateUpdated");
	            int menuID = rs.getInt("menu.menuID");
	            if(type.equals(Menu.PACKAGE_TYPE)) {
				    menu.add(new Package(id, name, price, dateAdded.toLocalDateTime(), dateUpdated.toLocalDateTime(), loadPackageItemFromDatabase(id), menuID));    
				}else if(type.equals(Menu.ITEM_TYPE)) {
					menu.add(new Item(id, name, price, dateAdded.toLocalDateTime(), dateUpdated.toLocalDateTime(), menuID));
				}
	        }
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}

	public static void loadItemsFromDatabase() throws SQLException {
	    Database db = null;
	    items.clear();
	    try {
	        db = new Database();
	        ResultSet rs = db.executeStatement("Select * FROM items");
	        while (rs.next()) {
	            String id = rs.getString("itemID");
	            String name = rs.getString("name");
	            float price = rs.getFloat("price");
	            Timestamp dateAdded = rs.getTimestamp("dateAdded");
	            Timestamp dateUpdated = rs.getTimestamp("dateUpdated");
	            int menuID = rs.getInt("menuID");
				items.add(new Item(id, name, price, dateAdded.toLocalDateTime(), dateUpdated.toLocalDateTime(), menuID));
	        }
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}

	public static void loadPackageFromDatabase() throws SQLException {
	    Database db = null;
	    try {
	    	pack.clear();
	        db = new Database();
	        Statement stmt = db.getConn().createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM package");
	        while (rs.next()) {
	            String id = rs.getString("packageID");
	            String name = rs.getString("name");
	            float price = rs.getFloat("price");
	            Timestamp dateAdded = rs.getTimestamp("dateAdded");
	            Timestamp dateUpdated = rs.getTimestamp("dateUpdated");
	            int menuID = rs.getInt("menuID");
				pack.add(new Package(id, name, price, dateAdded.toLocalDateTime(), dateUpdated.toLocalDateTime(), loadPackageItemFromDatabase(id), menuID));
	        }
	    } catch (SQLException e) {
	        throw e;
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
		
	public static ArrayList<Item> loadPackageItemFromDatabase(String idd) {
		ArrayList<Item> packItem = new ArrayList<Item>();
		Database db = null;
		
		try {
			Package temp = Database.getPackageByID(idd);
			db = new Database();
			db.setPst("Select itemID, quantity FROM packageitem WHERE packageID = ?");
			db.getPst().setString(1, idd);
		    ResultSet rs = db.getPst().executeQuery();
		    while (rs.next()) {
	            String itemID = rs.getString("itemID");
	            Item item = getItemByID(itemID);
	            item.setQuantity(rs.getInt("quantity"));
		    	packItem.add(item);
	        }
		    temp.setPackageitems(packItem);
		} catch (SQLException | MenuNotFoundException e) {
	       
	    }finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
		return packItem;
	}
	
	public static void loadOrdersFromDatabase() throws SQLException, MenuNotFoundException{
		 Database db = null;
		 try {
		   	orders.clear();
		   	db = new Database();
		   	Statement stmt = db.getConn().createStatement();
		   	ResultSet rs = stmt.executeQuery("SELECT * FROM orders");
		    while (rs.next()) {
		    	int id = rs.getInt("orderID");
		        int menuID = rs.getInt("menuID");
		        String orderMethod = rs.getString("orderMethod");
		        String deliveryMethod = rs.getString("deliveryMethod");
		        float total = rs.getFloat("total");
		        orders.add(new Order(id, orderMethod, deliveryMethod, total, loadOrderItemsFromDatabase(id)));
		    }
		 } finally {
		     if (db != null) {
		    	 db.closeConn();
		     }
		 }

	}
	
	public static ArrayList<Menu> loadOrderItemsFromDatabase(int orderID) throws SQLException, MenuNotFoundException{
		Database db = null;
		ArrayList<Menu> orderItems = new ArrayList<Menu>();
		 try {
		   	db = new Database();
		   	Statement stmt = db.getConn().createStatement();
		   	ResultSet rs = stmt.executeQuery("SELECT menuID FROM orderitems WHERE orderID = ?");
		    while (rs.next()) {
		    	orderItems.add(getMenuByMenuID(rs.getInt("menuID")));
		    }
		 } finally {
		     if (db != null) {
		    	 db.closeConn();
		     }
		 }
		 return orderItems;

	}
	
	public static void loadFeedbackFromDatabase() throws SQLException {
	    Database db = null;
	    feedback.clear();
	    try {
	        db = new Database();
	        ResultSet rs = db.executeStatement("SELECT * FROM `employee feedback`");
	        while (rs.next()) {
	            int id = rs.getInt("feedbackID");
	            String message = rs.getString("message");
	            Timestamp dateAdded = rs.getTimestamp("dateAdded");
	            String userID = rs.getString("userID");
				feedback.add(new Feedbacks(id,userID, message, dateAdded.toLocalDateTime()));
	        }
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
	
	
////////////////////////////////////////////////////////////////////////////
////////////////ADDING DATA/////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
	public static void addUser(UserClass u) throws SQLException, NameExistsInArrayException {
		Database db = null;
		try {
			db = new Database();
			db.setPst("INSERT INTO user (userID, name, password, contactNo, role, userCreated, userUpdated, editorID) \r\n"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			db.getPst().setString(1, u.getId());
			db.getPst().setString(2, nameExist(u.getUserName(), "USER"));
			db.getPst().setString(3, u.getPassword());
			db.getPst().setString(4, u.getContact());
			db.getPst().setString(5, u.getRole());
			db.getPst().setTimestamp(6, Timestamp.valueOf(u.getUserCreatedLDT()));
			db.getPst().setTimestamp(7, Timestamp.valueOf(u.getUserUpdatedLDT()));
			db.getPst().setString(8, u.getEditedByID());
			db.getPst().executeUpdate();
			
			users.add(u);
			
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
	
	public static void addMenu(String type) throws SQLException {
		Database db = new Database();
		try {
			System.out.println(getLastMenuID());
			db = new Database();
			db.setPst("INSERT INTO menu(menuID, menuType) VALUES(?, ?)");
			db.getPst().setInt(1, getLastMenuID()+1);
			db.getPst().setString(2, type);
			db.getPst().executeUpdate();
			
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}

	public static void addItem(Item item) throws SQLException, NameExistsInArrayException {
		Database db = new Database();
		try {
			db = new Database();
			db.setPst("INSERT INTO items (itemID, name, price,  dateAdded, dateUpdated, menuID) \r\n"
					+ "VALUES (?, ?, ?, current_timestamp(), current_timestamp(), ?)");
			db.getPst().setString(1, item.getId());
			db.getPst().setString(2, nameExist(item.getName(), "ITEMS"));
			addMenu(item.getType());
			db.getPst().setDouble(3, item.getPrice());
			db.getPst().setInt(4, getLastMenuID());
			db.getPst().executeUpdate();
			
			items.add(item);
			menu.add(item);
			
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}

	public static void addPackage(Package packag) throws SQLException, NameExistsInArrayException {
		Database db = new Database();
		try {
			db = new Database();
			db.setPst("INSERT INTO Package (packageID, name, price, count, dateAdded, dateUpdated, menuID) \r\n"
					+ "VALUES (?, ?, ?, ?, current_timestamp(), current_timestamp(), ?)");
			db.getPst().setString(1, packag.getId());
			db.getPst().setString(2, nameExist(packag.getName(), "PACKAGE"));
			addMenu(packag.getType());
			db.getPst().setDouble(3, packag.getPrice());
			db.getPst().setInt(4, Integer.parseInt("0"));
			db.getPst().setInt(5, getLastMenuID());
			db.getPst().executeUpdate();
			pack.add(packag);
			menu.add(packag);
			
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
	
	public static void addPackageItem(Package p, Item i, int qty) throws SQLException {
		Database db = new Database();
		try {
			db = new Database();
			db.setPst("INSERT INTO packageitem (packageItemID, quantity, itemID, packageID) VALUES (?, ?, ?, ?)");
			db.getPst().setInt(1, getLastPackageItemID());
			db.getPst().setInt(2, qty);
			db.getPst().setString(3, i.getId());
			db.getPst().setString(4, p.getId());
			db.getPst().executeUpdate();
			int packInt = getPackageIndex(p);
			i.setQuantity(qty);
			pack.get(packInt).getPackageitems().add(i);
			p.getPackageitems().add(i);
		} catch (MenuNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	        if (db != null) {
	            db.closeConn();
	        }
		}
	}

	public static void addOrder(Order order) throws SQLException {
		Database db = new Database();
		try {
			orders.add(order);
			db = new Database();
			db.setPst("INSERT INTO orders (orderID, orderMethod, deliveryMethod, total) VALUES (?, ?, ?, ?);");
			db.getPst().setInt(1, order.getId());
			db.getPst().setString(2, order.getOrderMethod());
			db.getPst().setString(3, order.getDeliveryMethod());
			db.getPst().setFloat(4, order.getTotal());
			db.getPst().executeUpdate();
			for(Menu i: order.getMenuOrders()) {
				addOrderItems(order, i.getMenuID(), i.getQuantity());
			}
			
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
	
	public static void addOrderItems(Order order, int menuID, int qty) throws SQLException {
		Database db = new Database();
		try {
			
			db = new Database();
			db.setPst("INSERT INTO orderitems (orderItemsID, orderID, quantity, notes, menuID) VALUES (?, ?, ?, ?, ?)");
			db.getPst().setInt(1, getLastOIID());
			db.getPst().setInt(2, order.getId());
			db.getPst().setInt(3, qty);
			db.getPst().setString(4, "");
			db.getPst().setInt(5, menuID);
			db.getPst().executeUpdate();
			
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
	
	public static void addBilling(BillingAddress bill) throws SQLException {
		Database db = new Database();
		try {
			
			db = new Database();
			db.setPst("INSERT INTO billingaddress (billingID, name, emailAdd, contactNo) VALUES (?, ?, ?, ?)");
			db.getPst().setInt(1, bill.getId());
			db.getPst().setString(2, bill.getName());
			db.getPst().setString(3, bill.getEmailAdd());
			db.getPst().setString(4, bill.getContactNo());
			db.getPst().executeUpdate();
			
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
	public static void addInvoice(Invoice inv) throws SQLException {
		Database db = new Database();
		try {
			
			db = new Database();
			db.setPst("INSERT INTO invoice (invoiceID, paymentMethod, shippingAdd, status, billingID, voucherID, orderID, userID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			db.getPst().setInt(1, inv.getId());
			db.getPst().setString(2, inv.getPaymentMethod());
			db.getPst().setString(3, inv.getShippingAdd());
			db.getPst().setString(4, "");
			db.getPst().setInt(5, inv.getBillingID());
			db.getPst().setInt(6, inv.getVoucherID());
			db.getPst().setInt(7, inv.getOrderID());
			db.getPst().setString(8, inv.getUserID());
			db.getPst().executeUpdate();
			
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
	
	
	
	public static void addFeedback(Feedbacks f) throws SQLException  {
		
		Database db = new Database();
		
		try {
			db = new Database();
			db.setPst("INSERT INTO `employee feedback` (feedbackID, message, dateAdded, userID) \r\n"
					+ "VALUES (?, ?, current_timestamp(), ?)");
			
			db.getPst().setInt(1, f.getId());
			db.getPst().setString(2, f.getMessage());
			db.getPst().setString(3, f.getUserID());
			db.getPst().executeUpdate();
			feedback.add(f);
			
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}

////////////////////////////////////////////////////////////////////////////
////////////////UPDATE DATA/////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
	
	public static void updateUser(String id, String username, String password, String contact, String role, String editedByID) throws SQLException {
		Database db = new Database();
		try {
			db = new Database();
			db.setPst("UPDATE user SET name = ?, password = ?, contactNo = ?, role = ?, userUpdated = current_timestamp(), editorID = ? WHERE userID = ?");
			db.getPst().setString(1, username);
			db.getPst().setString(2, password);
			db.getPst().setString(3, contact);
			db.getPst().setString(4, role);
			db.getPst().setString(5, editedByID);
			db.getPst().setString(6, id);
			db.getPst().executeUpdate();
			
			for(UserClass user : users) {
				if(id.equals(user.getId())) {
					user.setUserName(username);
					user.setPassword(password);
					user.setContact(contact);
					user.setRole(role);
					user.setUserUpdated(LocalDateTime.now());
					user.setEditedBy(editedByID);
					return;
				}
			}
	    }finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
	
	public static void updateItem(String id, String name, float price) throws SQLException, NameExistsInArrayException {
		Database db = new Database();
		try {
			db = new Database();
			db.setPst("UPDATE items SET name = ?, price = ?, dateUpdated = current_timestamp() WHERE itemID = ?");
			db.getPst().setString(1, name);
			db.getPst().setFloat(2, price);
			db.getPst().setString(3, id);
			db.getPst().executeUpdate();
			
			for(Item item: items) {
				if(id.equals(item.getId())) {
					item.setName(name);
					item.setPrice(price);
					item.setDateUpdated(LocalDateTime.now());
					return;
				}
			}
	    }finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
	
	public static void updatePackage(String id, String name, float price, int count) throws SQLException, NameExistsInArrayException {
		Database db = new Database();
		try {
			
			for(Package p: pack) {
				if(id.equals(p.getId())) {
					db = new Database();
					db.setPst("UPDATE package SET name = ?, price = ?, count = ?, dateUpdated = current_timestamp() WHERE packageID = ?");
					db.getPst().setString(1, name);
					db.getPst().setFloat(2, price);
					db.getPst().setFloat(3, count);
					db.getPst().setString(4, id);
					db.getPst().executeUpdate();
					
					p.setName(name);
					p.setPrice(price);
					p.setDateUpdated(LocalDateTime.now());
					return;
				}
			}
			
	    }finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}

	public static void updatePackageItem(String packID, String itemID, int qty) throws SQLException{
		Database db = new Database();
		
		try {
			db = new Database();
			db.setPst("UPDATE packageitem SET quantity = ? WHERE itemID = ? AND packageID = ?");
			db.getPst().setInt(1, qty);
			db.getPst().setString(2, itemID);
			db.getPst().setString(3, packID);
			db.getPst().executeUpdate();
			for(Package p: pack) {
				if(p.getId().equals(packID)) {
					for(Item i: p.getPackageitems()) {
						i.setQuantity(qty);
						break;
					}
					break;
				}
			}
		} finally {
	        if (db != null) {
	            db.closeConn();
	        }
		}	
	}
	
	public static void updateOrderItem(ArrayList<Menu> orderItems, Order order) throws SQLException{
		Database db = new Database();
		
		try {
			db = new Database();
			db.setPst("DELETE FROM orderitems WHERE orderID = ?");
			db.getPst().setInt(1, order.getId());
			db.getPst().executeUpdate();
			for(Menu oi: orderItems) {
				db.setPst("UPDATE orderitems SET quantity = ? WHERE menuID = ? AND orderID = ?");
				db.getPst().setInt(1, oi.getQuantity());
				db.getPst().setInt(2, oi.getMenuID());
				db.getPst().setInt(3, order.getId());
				db.getPst().executeUpdate();
			}
			
			for(Order o: orders) {
				if(o.getId() == order.getId()) {
					for(Menu oi: orderItems) {
						o.getMenuOrders().add(oi);
					}
					break;
				}
			}
		} finally {
	        if (db != null) {
	            db.closeConn();
	        }
		}	
	}
	
	
	
////////////////////////////////////////////////////////////////////////////
////////////////REMOVE DATA/////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
	
	public static void removeUser(UserClass user) throws SQLException {
		Database db = new Database();
		try {
			db.setPst("DELETE FROM user WHERE userID = ?");
			db.getPst().setString(1, user.getId());
			db.getPst().executeUpdate();
			
			users.remove(user);
			
		} finally {
			if(db != null) {
				db.closeConn();
			}
		}
	}
	
	public static void removeMenu(Package packag) throws SQLException {
		Database db = new Database();
		try {
			db = new Database();
			db.setPst("DELETE FROM menu WHERE menuID = (SELECT menuID FROM package WHERE packageID = ?)");
			db.getPst().setString(1, packag.getId());
			db.getPst().executeUpdate();
			pack.remove(packag);
			menu.remove(packag);
			
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}

	public static void removeMenu(Item item) throws SQLException {
		Database db = new Database();
		try {
			db = new Database();
			db.setPst("DELETE FROM menu WHERE menuID = (SELECT menuID FROM items WHERE itemID = ?)");
			db.getPst().setString(1, item.getId());
			db.getPst().executeUpdate();
			items.remove(item);
			menu.remove(item);
			
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
		
	}

	public static void removePackageItem(Package p, Item i) throws SQLException {
		Database db = new Database();
		
		try {
			db = new Database();
			db.setPst("DELETE FROM packageitem WHERE itemID = ? && packageID = ?");
			db.getPst().setString(1, i.getId());
			db.getPst().setString(2, p.getId());
			db.getPst().executeUpdate();
			pack.get(getPackageIndex(p)).getPackageitems().remove(i);
		} catch (MenuNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	        if (db != null) {
	            db.closeConn();
	        }
		}	
	}
	
////////////////////////////////////////////////////////////////////////////
////////////////GET INDEX OF OBJECT FROM ARRAY////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////	

	public static int getUserIndex(UserClass user) throws UserNotFoundException{
		int index = 0;
		for(UserClass u: users) {
			if(user.getId().equals(u.getId())){
				return index;
			}
			index++;
		}
		throw new UserNotFoundException();
	}
	
	public static int getMenuIndex(Menu men) throws MenuNotFoundException{
		int index = 0;
		for(Menu m: menu) {
			if(men.getId().equals(m.getId())){
				return index;
			}
			index++;
		}
		throw new MenuNotFoundException();
	}
	
	public static int getItemIndex(Item item) throws MenuNotFoundException{
		int index = 0;
		for(Item i: items) {
			if(item.getId().equals(i.getId())){
				return index;
			}
			index++;
		}
		throw new MenuNotFoundException();
	}
	
	private static int getPackageIndex(Package p) throws MenuNotFoundException {
		int index = 0;
		for(index = 0; index<pack.size(); index++) {
			if(pack.get(index).getId().equals(p.getId())) {
				return index;
			}
		}

		throw new MenuNotFoundException();
	}

////////////////////////////////////////////////////////////////////////////
////////////////GET OBJECT FROM ARRAY///////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
	
	//get a user from array
	public static UserClass getUserByID(String id) throws UserNotFoundException {
		for(UserClass user: users) {
			if(id.equals(user.getId())) {
				return user;
			}
		}
		throw new UserNotFoundException();
	}
	

	public static Menu getMenuByID(String id) throws MenuNotFoundException{
		for(Menu m: menu) {
			if(id.equals(m.getId())) {
				return m;
			}
		}
		throw new MenuNotFoundException();
	}
	
	public static Menu getMenuByMenuID(int id) throws MenuNotFoundException{
		for(Menu m: menu) {
			if(m.getMenuID() == id) {
				return m;
			}
		}
		throw new MenuNotFoundException();
	}
	
	public static Item getItemByID(String id) throws MenuNotFoundException {
		for(Item i: items) {
			if(id.equals(i.getId())) {
				return i;
			}
		}
		throw new MenuNotFoundException();
	}
	
	public static Package getPackageByID(String id) throws MenuNotFoundException {
		for(Package p: pack) {
			if(id.equals(p.getId())) {
				return p;
			}
		}
		throw new MenuNotFoundException();
	}
	
	
	
////////////////////////////////////////////////////////////////////////////
////////////////GET LAST USER ID///////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
	
	public static int getLastUserID(){
		if(users.isEmpty()) {
			return 1;
		}
		return Integer.parseInt(users.get(users.size()-1).getId().substring(1))+1;
	}

	// remove a user
	public static int getLastMenuID() throws SQLException {
		Database db = new Database();
		int ret = 1;
		try {
			db = new Database();
			ResultSet rs = db.executeStatement("SELECT MAX(menuID) FROM menu");
			
			if(rs.next()) {
				ret = rs.getInt("MAX(menuID)");
			}
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
		return ret;
	}
	
	public static int getLastItemID(){
		if(items.isEmpty()) {
			return 1;
		}
		return Integer.parseInt(items.get(items.size()-1).getId().substring(1))+1;
	}
	
	public static int getLastPackageID() {
		if(pack.isEmpty()) {
			return 1;
		}
		return Integer.parseInt(pack.get(pack.size()-1).getId().substring(1))+1;
	}
	/////////////////////PACKAGE ITEM////////////////////////////////
	

	
	public static int getLastPackageItemID() throws SQLException {
		
		Database db = null;
		int id = 0;
	    try {
	        db = new Database();
	        Statement stmt = db.getConn().createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT MAX(packageItemID) FROM packageitem");
	        while (rs.next()) {
	        	id = rs.getInt(1);
	        }
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
		return id + 1;
	}
	
	public static int getLastOrderID() throws SQLException {
		Database db = new Database();
		try {
			db = new Database();
		   	Statement stmt = db.getConn().createStatement();
		   	ResultSet rs = stmt.executeQuery("SELECT MAX(orderID) AS nextID FROM orders");
		    if (rs.next()) {
		    	return rs.getInt("nextID")+1;
		    }else {
		    	return 1;
		    }
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
	
	public static int getLastBillingID() throws SQLException {
		Database db = new Database();
		try {
			db = new Database();
		   	Statement stmt = db.getConn().createStatement();
		   	ResultSet rs = stmt.executeQuery("SELECT MAX(billingID) AS nextID FROM billingaddress");
		    if (rs.next()) {
		    	return rs.getInt("nextID")+1;
		    }else {
		    	return 1;
		    }
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
	
	public static int getLastInvoiceID() throws SQLException {
		Database db = new Database();
		try {
			db = new Database();
		   	Statement stmt = db.getConn().createStatement();
		   	ResultSet rs = stmt.executeQuery("SELECT MAX(invoiceID) AS nextID FROM invoice");
		    if (rs.next()) {
		    	return rs.getInt("nextID")+1;
		    }else {
		    	return 1;
		    }
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
	
	public static int getLastOIID() throws SQLException {
		Database db = new Database();
		try {
			db = new Database();
		   	Statement stmt = db.getConn().createStatement();
		   	ResultSet rs = stmt.executeQuery("SELECT MAX(orderItemsID) AS nextID FROM orderitems");
		    if (rs.next()) {
		    	return rs.getInt("nextID")+1;
		    }else {
		    	return 1;
		    }
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
	}
	
	public static int getLastFeedbackID() throws SQLException {
		Database db = new Database();
		int ret = 1;
		try {
			db = new Database();
			ResultSet rs = db.executeStatement("SELECT MAX(feedbackID) FROM `employee feedback`");
			
			if(rs.next()) {
				ret = rs.getInt("MAX(feedbackID)");
			}
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
		return ret + 1;
	}
	
	public static int getLastVoucherID() throws SQLException {
		Database db = new Database();
		int ret = 1;
		try {
			db = new Database();
			ResultSet rs = db.executeStatement("SELECT MAX(voucherID) FROM vouchers");
			
			if(rs.next()) {
				ret = rs.getInt("MAX(voucherID)");
			}
	    } finally {
	        if (db != null) {
	            db.closeConn();
	        }
	    }
		return ret + 1;
	}
	
	
	
	//////////////////CHECK DUPLICATE////////////////////////////////////
	//Check for duplicates in the array
	public static String nameExist(String name, String array) throws NameExistsInArrayException {
		if(array.equals("USER")) {
			for(UserClass n: users) {
				if(name.equals(n.getUserName())) {
					throw new NameExistsInArrayException();
				}
			}
		}else if(array.equals("ITEMS")) {
			for(Item n: items) {
				if(name.equals(n.getName())) {
					throw new NameExistsInArrayException();
				}
			}
		}else if(array.equals("PACKAGE")) {
			for(Package n: pack) {
				if(name.equals(n.getName())) {
					throw new NameExistsInArrayException();
				}
			}
		}
			
		
		return name;
	}

}
