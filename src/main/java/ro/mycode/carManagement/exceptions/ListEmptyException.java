package ro.mycode.carManagement.exceptions;

public class ListEmptyException extends RuntimeException{

    public ListEmptyException() {
        super("Empty list !");
    }
}
