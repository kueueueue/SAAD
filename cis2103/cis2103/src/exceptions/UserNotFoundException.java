package exceptions;

public class UserNotFoundException extends Exception{
	public UserNotFoundException(String s) {
		super(s);
	}
	
	public UserNotFoundException() {
		super("User does not exist.");
	}
}
