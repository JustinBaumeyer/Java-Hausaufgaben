package code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ZahlwortTest {

    @Test
    public void testTabelle() {
        int[] testtabelle = { 1, 10, 11, 12, 16, 17, 20, 38, 69, 70, 131, 195, 2345 };
        String[] testout = {"eins","zehn","elf","zwoelf","sechzehn","siebzehn","zwanzig","achtunddreissig","neunundsechzig","siebzig","einhunderteinunddreissig","einhundertfuenfundneunzig","zweitausenddreihundertfuenfundvierzig"};

        for(int i = 0; i < Math.min(testtabelle.length,testout.length);i++) {
            assertEquals(testout[i],Zahlwort.getZahlwort(testtabelle[i]));
        }
    }

    @Test
    public void testExceptions() {
        assertThrows(ArithmeticException.class, () -> Zahlwort.getZahlwort(0));
        assertThrows(ArithmeticException.class, () -> Zahlwort.getZahlwort(10000));
    }

    @Test
    public void testStream() {
        String[] s = Zahlwort.getZahlStream(8,12).toArray(String[]::new);
        assertArrayEquals(s,new String[]{"acht","neun","zehn","elf","zwoelf"});
    }
}