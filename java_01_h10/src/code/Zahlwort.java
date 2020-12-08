package code;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Zahlwort {
    private static String[] small = new String[]{"", "ein", "zwei",
            "drei", "vier", "fuenf", "sechs", "sieben", "acht", "neun", "zehn", "elf", "zwoelf", "dreizehn", "vierzehn", "fuenfzehn", "sechzehn", "siebzehn", "achtzehn", "neunzehn"};
    private static String[] tens = new String[]{"", "zehn", "zwanzig",
            "dreissig", "vierzig", "fünfzig", "sechzig", "siebzig", "achtzig",
            "neunzig"};
    private static String[] big = new String[]{"", "tausend", "millionen", "milliarden", "billionen", "billiarden"};

    public static String getZahlwort(long i) {
        if (i < 1 || i > 9999) throw new ArithmeticException("i must be between 1 and 9999"); //☹
        StringBuilder out = new StringBuilder();
        int u = 1;
        while (true) {
            int r100 = (int) (i % 100);
            if (r100 >= 20) {
                if (r100 % 10 == 0) {
                    out.insert(0, tens[r100 / 10]);
                } else {
                    out.insert(0, small[r100 % 10] + "und" + tens[r100 / 10]);
                }
            } else if (r100 != 0) {
                out.insert(0, small[r100].equals("ein") ? "eins" : small[r100]);
            }
            int hundrets = (int) (i % 1000) / 100;
            if (hundrets != 0) {
                out.insert(0, small[hundrets] + "hundert");
            }
            i /= 1000;
            if (i == 0) break;
            out.insert(0, big[u]);

            u++;
        }
        return out.toString().trim();

    }

    public static Stream<String> getZahlStream(int start, int stop) {
        return IntStream.range(start, stop + 1).mapToObj(Zahlwort::getZahlwort);
    }
}