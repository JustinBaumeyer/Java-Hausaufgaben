package code;

import java.math.BigInteger;
import java.util.stream.Stream;

public class ZahlwortTest {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Test 1:");
        int[] testtabelle = {1, 10, 11, 12, 16, 17, 20, 38, 69,
                70, 131, 195, 201, 202, 211, 1111, 2345};
        for (int z : testtabelle) {
            String zahlwort = Zahlwort.getZahlwort(z);
            System.out.println("zahl = " + z + " --> " + zahlwort);
        }
// testen, ob die Stream-Methode ordentlich funktioniert:
        System.out.println();
        System.out.println("Test 2:");
        int start = 8;
        int stop = 12;
        Stream<String> ss = Zahlwort.getZahlStream(start, stop);
        ss.limit(stop - start + 1).forEach(System.out::println);
// sollte eine Ausnahme produzieren:
        System.out.println();
        System.out.println("Test 3:");
        int zahl = 10000;
        try {
            String wort = Zahlwort.getZahlwort(zahl);
        } catch (Exception exception) {
            System.out.println("Exception thrown!");
        }
        //System.out.println(Zahlwort.getZahlwort(new BigInteger("132178248961852358916451287612467142145631475619743614567899456789134767453978614673679857914369785165565115521")));
    }
}
