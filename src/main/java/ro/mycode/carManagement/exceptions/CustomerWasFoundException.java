package ro.mycode.carManagement.exceptions;

public class CustomerWasFoundException extends RuntimeException{
    public CustomerWasFoundException() {
        super("Customer was found! ");
    }
}
