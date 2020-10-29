package operations;

import interfaces.Rechenoperation;

public class Quadratwurzel implements Rechenoperation {
    @Override
    public double berechne(double x) {
        if(x < 0) throw new ArithmeticException("Negative Zahlen nicht unterstützt!");
        return Math.sqrt(x);
    }
}
