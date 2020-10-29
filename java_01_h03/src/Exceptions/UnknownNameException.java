package Exceptions;

public class UnknownNameException extends Exception {
    public UnknownNameException() {
        super();
    }

    public UnknownNameException(String message) {
        super(message);
    }
}
