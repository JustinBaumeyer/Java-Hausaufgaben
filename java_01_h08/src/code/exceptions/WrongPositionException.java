package code.exceptions;

public class WrongPositionException extends RuntimeException {
    public WrongPositionException() {
        super("Diese code.Position liegt nicht auf dem Brett!");
    }
}
