package code;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Zahlwort {
    private static String[] small = new String[]{"null", "ein", "zwei",
            "drei", "vier", "fuenf", "sechs", "sieben", "acht", "neun", "zehn", "elf", "zwoelf", "dreizehn", "vierzehn", "fuenfzehn", "sechzehn", "siebzehn", "achtzehn", "neunzehn"};
    private static String[] tens = new String[]{"", "zehn", "zwanzig",
            "dreissig", "vierzig", "fuenfzig", "sechzig", "siebzig", "achtzig",
            "neunzig"};
    private static String[] big = new String[]{
            "", "tausend", "millionen", "milliarden", "billionen", "billiarden", "trillionen", "trilliarden",
            "quadrillionen", "quadrilliarden","quintillionen","quintilliarden","sextillionen","sextilliarden",
            "septillionen","septilliarden","oktillionen","oktilliarden","nonillionen","nonilliarden","dezillionen","dezilliarden",
            "undezillionen","undezilliarden","dodezillionen","dodezilliarden","tredezillionen","tredezilliarden","quattuordezillionen",
            "quattuordezilliarden","quindezillionen","quindezilliarden","sedezillionen","sedezilliarden","septendezillionen","septendezilliarden",
            "dodevigintillionen","dodevigintilliarden"};

    /**
     * @param x Zahl, die ausgegeben werden soll
     * @return Gibt die Zahl i als deutsches Zahlwort zurueck.
     * @throws ArithmeticException Wirft eine ArithmeticException, wenn die Zahl nicht im gewuenschten Bereich liegt
     */
    public static String getZahlwort(int x) {
        if (x < 1 || x > 9999) throw new ArithmeticException("x must be between 1 and 9999"); //☹
        return getZahlwort(BigInteger.valueOf(x));
    }

    /**
     * @param i Zahl, die ausgegeben werden soll
     * @return Gibt die Zahl i als deutsches Zahlwort zurueck.
     * @throws ArithmeticException Wirft eine ArithmeticException, wenn die Zahl nicht im deklarierten Bereich liegt
     */
    public static String getZahlwort(BigInteger i) {
        BigInteger border = BigInteger.valueOf(10).pow(big.length * 3).subtract(BigInteger.valueOf(1));
        boolean negativ = i.compareTo(BigInteger.valueOf(0)) < 0;

        if (negativ) i = i.abs();
        if (i.compareTo(border) > 0) throw new ArithmeticException("i must be between -" + border + " and " + border);
        StringBuilder out = new StringBuilder();
        int bigIndex = 1;

        while (true) {
            int r100 = i.mod(BigInteger.valueOf(100)).intValue();
            if (r100 >= 20) {
                //Bei einem r100 >=20 muss ueberprueft werden, ob es sich um eine Zahl aus dem tens Array handelt.
                //Wenn dem so ist, wird diese Zahl eingefuegt. Wenn dem nicht so ist muss wie z.B bei der Zahl 32 erst
                //die 2 als Wort, gefolgt von einem "und" und dem Zehner, hinzugefuegt werden.
                if (r100 % 10 == 0) {
                    out.insert(0, tens[r100 / 10]);
                } else {
                    out.insert(0, small[r100 % 10] + "und" + tens[r100 / 10]);
                }
            } else if (r100 != 0) {
                //Wenn r100 kleiner als 20 und ungleich 0 ist, kann sofort die Zahl in small an Stelle r100 benutzt werden.
                out.insert(0, small[r100]);
            }
            //An dieser Stelle werden die hunderter eingefuegt, falls sie existieren.
            //Dafuer wird mit (n%1000)/100 die Anzahl dieser ausgerechnet.
            int hundrets = i.mod(BigInteger.valueOf(1000)).divide(BigInteger.valueOf(100)).intValue();
            if (hundrets != 0) {
                out.insert(0, small[hundrets] + "hundert");
            }
            //Am Ende wird die zu betrachtende Zahl durch 1000 geteilt und, wenn keine weiteren Zahlen vorhanden sind, die Schleife unterbrochen.
            i = i.divide(BigInteger.valueOf(1000));
            if (i.equals(BigInteger.ZERO)) break;
            //Hinzufuegen der Prefix fuer tausend, millionen etc
            out.insert(0, big[bigIndex++]);
        }
        //Behandlung der Spezialfälle fuer die eins.

        //Fuegt ein "e" zur "ein" am Anfang hinzu, wenn die darauf folgenden Elemente aus big nicht hundert oder tausend sind.
        if (out.indexOf(small[1]) == 0) {
            if(out.length() > small[1].length() &&(out.indexOf("hundert") != small[1].length()) && (out.indexOf("tausend") != small[1].length())) {
                out.insert(small[1].length(), "e");
            }
        }

        //Fuegt ein s an das Ende der Zahl, wenn sie auf eins endet.
        if (out.lastIndexOf(small[1]) == out.length() - small[1].length()) {
            out.append("s");
        }

        if(out.toString().trim().length()==0) out.insert(0,small[0]);
        if (negativ) out.insert(0, "minus ");

        return out.toString().trim();

    }

    /**
     * @param start Unterstes zurueckzugebendes  Zahlwort
     * @param stop  Oberstes zurueckzugebendes  Zahlwort
     * @return Gibt einen String Stream mit den angeforderten Zahlworten zurueck.
     */
    public static Stream<String> getZahlStream(int start, int stop) {
        return IntStream.rangeClosed(start, stop).mapToObj(Zahlwort::getZahlwort);
    }
}