package exceptions;

public class CancelledActionException extends Exception{
	public CancelledActionException() {
		super("This method is cancelled.");
	}
}
