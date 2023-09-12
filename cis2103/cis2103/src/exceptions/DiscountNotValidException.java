package exceptions;

public class DiscountNotValidException extends Exception{
	public DiscountNotValidException() {
		super("Discount is invalid.");
	}
	
	public DiscountNotValidException(String s) {
		super(s);
	}
}
