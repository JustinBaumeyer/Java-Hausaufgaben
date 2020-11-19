package exceptions;

public class WrongNumberException extends RuntimeException{
    public WrongNumberException() {
        super();
    }

    public WrongNumberException(String message) {
        super(message);
    }
}
