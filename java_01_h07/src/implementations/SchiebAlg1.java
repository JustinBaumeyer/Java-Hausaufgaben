package implementations;

import interfaces.Loesungsalgorithmus;
import objects.Schiebepuzzle;

import java.util.Random;

public class SchiebAlg1 implements Loesungsalgorithmus {

    /**
     * Überschreibt die loese Methode von Loesungsalgorithmus
     * Das Schiebepuzzle wird gelöst, indem solange zufällig die Plättchen getauscht werden,
     * bis das Plättchen 1 an erster Stelle steht.
     *
     * @param schiebepuzzle Schiebepuzzle
     */
    @Override
    public void loese(Schiebepuzzle schiebepuzzle) {
        Random rnd = new Random();
        while (schiebepuzzle.getTiles()[0][0] != 1) {
            int tryableTile = rnd.nextInt(14) + 1;
            if (schiebepuzzle.istVerschiebbar(tryableTile)) {
                schiebepuzzle.schiebe(tryableTile);
            }
        }
    }
}
