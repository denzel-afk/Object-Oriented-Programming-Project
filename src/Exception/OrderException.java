package Exception;

public class OrderException extends Exception{
	  public OrderException() {
	    super("Order is undeterrmined");
	  }
	  
	  public OrderException(String message) {
	    super(message);
	  }
	}
