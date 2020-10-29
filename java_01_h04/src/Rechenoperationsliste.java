import interfaces.Rechenoperation;

import java.util.ArrayList;
import java.util.List;

public class Rechenoperationsliste {
    List<Rechenoperation> rechenoperationList;

    /**
     * initialisiert die Liste von Rechenoperationen
     */
    public Rechenoperationsliste() {
        this.rechenoperationList = new ArrayList<>();
    }

    /**
     * fuegt zur Liste der Rechenoperationen die uebergebene Operation
     * hinzu
     * @param operation
     */
    public void add(Rechenoperation operation) {
        this.rechenoperationList.add(operation);
    }

    /**
     * wendet alle Rechenoperationen der Reihe nach auf jedes Element
     * des uebergebenen Feldes an (siehe auch Testfall)
     * @param feld
     * @return
     */
    public double[] transform(double[] feld) {
        double[] res = new double[feld.length];
        double tmp;
        for(int i = 0; i < feld.length;i++) {
            tmp = feld[i];
            for (Rechenoperation operation : rechenoperationList) {
                tmp = operation.berechne(tmp);
            }
            res[i] = tmp;
        }
        return res;
    }
}
