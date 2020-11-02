package operations;

import interfaces.Rechenoperation;

public class Quadratwurzel implements Rechenoperation {
    /**
     * Gibt die berechnete Quadratwurzel von x zurück; wirft eine ArithmeticException, falls x negativ ist.
     * @param x
     * @return
     */
    @Override
    public double berechne(double x) {
        if(x < 0) throw new ArithmeticException("Negative Zahlen nicht unterstützt!");
        return Math.sqrt(x);
    }
}
