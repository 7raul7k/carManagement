package ro.mycode.carManagement.exceptions;

public class CarWasFoundException extends RuntimeException{

    public CarWasFoundException() {
        super("Car found!");
    }
}
