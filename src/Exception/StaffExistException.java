package Exception;

public class StaffExistException extends Exception {
    public StaffExistException(){
        super("Staff's ID already existed");
    }

    public StaffExistException(String message){
        super(message);
    }
}