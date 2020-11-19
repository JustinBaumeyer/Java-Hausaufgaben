import implementations.SchiebAlg1;
import interfaces.Loesungsalgorithmus;
import objects.Schiebepuzzle;

public class Test {
    public static void main(String[] args) {
        Schiebepuzzle puzzle = new Schiebepuzzle();
// Mischen nicht vergessen, ansonsten hat der Spieler sehr schnell gewonnen
        puzzle.mische();
// Testen des Loesungsalgorithmus
// -> zufaellig schieben
        System.out.println(puzzle);
        Loesungsalgorithmus alg1 = new SchiebAlg1();
        alg1.loese(puzzle);
        System.out.println(puzzle);
    }

}
