package operations;

import interfaces.Rechenoperation;

public class Addition implements Rechenoperation {
    double value;

    /**
     * Initialisiert Attribut value mit Parameter value.
     * @param value
     */
    public Addition(double value) {
        this.value = value;
    }

    /**
     * Gibt die Summe von x und dem Attribut value zurück.
     * @param x
     * @return
     */
    @Override
    public double berechne(double x) {
        return this.value + x;
    }
}
