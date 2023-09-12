
package exceptions;

public class NameExistsInArrayException extends Exception {
	public NameExistsInArrayException(String s) {
		super(s);
	}
	public NameExistsInArrayException() {
		super("Name already exists.");
	}
}

