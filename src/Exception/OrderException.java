package Exception;

public class OrderException extends Exception {
	public OrderException() {
		super("Order is undetermined");
	}

	public OrderException(String message) {
		super(message);
	}
}
