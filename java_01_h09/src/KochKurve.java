import java.math.RoundingMode;
import java.text.DecimalFormat;

public class KochKurve {
    private static final DecimalFormat decimalFormat = new DecimalFormat("##.#");

    public static void main(String[] args) {
        for(int i = 0; i < 3;i++) {
            System.out.print("Rekursionstiefe "+i+": ");
            kochKurve(0, 500, 500, 500, i);
            System.out.println();
        }
    }
    public static void kochKurve(double ax, double ay,
                                  double bx, double by,
                                  int rek) {
        kochKurveInner(ax,ay,bx,by,rek);
        System.out.print(getPointString(bx,by)+" ");
    }
    public static void kochKurveInner(double ax, double ay,
                                 double bx, double by,
                                 int rek) {
        if(rek == 0) {
            System.out.print(getPointString(ax,ay)+" ");
        } else {
            float f = (float) Math.sqrt(3) / 2;
            double bx1 = (ax + bx) / 2 + f * (by - ay) / 3;
            double by1 = (ay + by) / 2 + f * (ax - bx) / 3;

            kochKurveInner(ax, ay, (2 * ax + bx) / 3, (2 * ay + by) / 3, rek-1);
            kochKurveInner((2 * ax + bx) / 3, (2 * ay + by) / 3, bx1, by1, rek-1);
            kochKurveInner(bx1, by1, (ax + 2 * bx) / 3, (ay + 2 * by) / 3, rek-1);
            kochKurveInner((ax + 2 * bx) / 3, (ay + 2 * by) / 3, bx, by, rek-1);
        }
    }

    private static String getPointString(double x, double y) {
        decimalFormat.setRoundingMode(RoundingMode.FLOOR);
        return "("+decimalFormat.format(x)+"/"+decimalFormat.format(y)+")";
    }

}
