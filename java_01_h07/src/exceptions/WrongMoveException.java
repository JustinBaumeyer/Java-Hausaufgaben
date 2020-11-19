package exceptions;

public class WrongMoveException extends RuntimeException{
    public WrongMoveException() {
        super();
    }

    public WrongMoveException(String message) {
        super(message);
    }
}
