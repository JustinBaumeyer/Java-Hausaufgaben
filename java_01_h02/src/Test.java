import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) {
        try {
            Goldpreis test = new Goldpreis("gold.txt");
            System.out.println(test.getPreis("2009-10-20")); // 22870.0
            System.out.println(test.getPreis("2009-02-07")); // -1
            test.printMinMax();
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden");
        }
    }
}
