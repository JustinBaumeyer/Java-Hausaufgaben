package exceptions;

/**
 * WrongMoveException Klasse
 */
public class WrongMoveException extends RuntimeException {
    public WrongMoveException() {
        super("Zug ist nicht moeglich");
    }
}
