package code.exceptions;

/**
 * Klasse WrongPositionException
 */
public class WrongPositionException extends RuntimeException {
    public WrongPositionException() {
        super("Diese Position liegt nicht auf dem Brett!");
    }
}
