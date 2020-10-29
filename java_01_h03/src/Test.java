import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        EMailAdressBuch buch = new EMailAdressBuch();
        buch.einlesen("mitarbeiter_matse_extern.txt");
        buch.einlesen("mitarbeiter_matse_intern.txt");
        System.out.println(buch);
    }
}
