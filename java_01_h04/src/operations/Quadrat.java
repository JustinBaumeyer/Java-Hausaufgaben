package operations;

import interfaces.Rechenoperation;

public class Quadrat implements Rechenoperation {
    /**
     * Gibt das Quadrat von x zurück
     * @param x
     * @return
     */
    @Override
    public double berechne(double x) {
        return x*x;
    }
}
