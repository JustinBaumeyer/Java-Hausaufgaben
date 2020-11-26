package code;

public class Test {
    public static void main(String[] args) {
        Zahlwort.getZahlStream(1,50).forEach(System.out::println);
    }
}
