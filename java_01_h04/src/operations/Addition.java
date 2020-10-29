package operations;

import interfaces.Rechenoperation;

public class Addition implements Rechenoperation {
    double value;

    public Addition(double value) {
        this.value = value;
    }

    @Override
    public double berechne(double x) {
        return this.value + x;
    }
}
