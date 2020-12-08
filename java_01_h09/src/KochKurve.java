import java.math.RoundingMode;
import java.text.DecimalFormat;

public class KochKurve {
    private static final DecimalFormat decimalFormat = new DecimalFormat("##.#");

    /**
     * Ruft die Methode kochKurve fuer die Rekursionsstufen 0, 1 und 2 mit
     * den beiden uebergebenenen Punkten (0,500) und (500,500) auf.
     * @param args
     */
    public static void main(String[] args) {
        for(int i = 0; i < 3;i++) {
            System.out.print("Rekursionstiefe "+i+": ");
            kochKurve(0, 500, 500, 500, i);
            System.out.println();
        }
    }

    /**
     * Wrapper fuer die Methode kochKurveInner, die am Ende noch den letzten Punkt ausgibt.
     *
     * @param ax X-Koordinate von Punkt A
     * @param ay Y-Koordinate von Punkt A
     * @param bx X-Koordinate von Punkt B
     * @param by Y-Koordinate von Punkt B
     * @param rek Rekursionstiefe
     */
    public static void kochKurve(double ax, double ay,
                                  double bx, double by,
                                  int rek) {
        kochKurveInner(ax,ay,bx,by,rek);
        System.out.print(getPointString(bx,by)+" ");
    }

    /**
     * Berechnet die Koordinaten der Punkte der Koch-Kurve durch den in der Quellen angegebenene Algorithmus
     * und gibt diese aus. Anschließend wird die Methode Rekursiv aufgerufen, um die weiteren Zwischenschritte zu berechnen.
     *
     * @param ax X-Koordinate von Punkt A
     * @param ay Y-Koordinate von Punkt A
     * @param bx X-Koordinate von Punkt B
     * @param by Y-Koordinate von Punkt B
     * @param rek Rekursionstiefe
     */
    public static void kochKurveInner(double ax, double ay,
                                 double bx, double by,
                                 int rek) {
        if(rek == 0) {
            System.out.print(getPointString(ax,ay)+" ");
        } else {
            double f = Math.sqrt(3) / 2;
            double bx1 = (ax + bx) / 2 + f * (by - ay) / 3;
            double by1 = (ay + by) / 2 + f * (ax - bx) / 3;

            kochKurveInner(ax, ay, (2 * ax + bx) / 3, (2 * ay + by) / 3, rek-1);
            kochKurveInner((2 * ax + bx) / 3, (2 * ay + by) / 3, bx1, by1, rek-1);
            kochKurveInner(bx1, by1, (ax + 2 * bx) / 3, (ay + 2 * by) / 3, rek-1);
            kochKurveInner((ax + 2 * bx) / 3, (ay + 2 * by) / 3, bx, by, rek-1);
        }
    }

    /**
     * @param x X-Koordinate des auszugebenden Punktes
     * @param y Y-Koordinate des auszugebenden Punktes
     * @return Gibt den uebergebenden Punkt in einer schoeneren Formatierung zurueck, indem beispielsweise
     * die Koordinaten, wie in der Beispielsausgabe in der Aufgabenstellung auch, auf eine Nachkommastelle genau, abgerundet werden.
     */
    private static String getPointString(double x, double y) {
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        return "("+decimalFormat.format(x)+"/"+decimalFormat.format(y)+")";
    }

}
