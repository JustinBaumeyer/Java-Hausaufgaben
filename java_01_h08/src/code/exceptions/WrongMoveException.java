package code.exceptions;

public class WrongMoveException extends RuntimeException {
    public WrongMoveException() {
        super("Das Feld kann in diesem Zug nicht erreicht werden!");
    }
}
