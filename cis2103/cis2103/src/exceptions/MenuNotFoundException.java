package exceptions;

public class MenuNotFoundException extends Exception{
	public MenuNotFoundException() {
		super("This menu item does not exist.");
	}
}
