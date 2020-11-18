import java.util.Comparator;
import java.util.Map;

public class BlattVergleich implements Comparator<Blatt> {

    /**
     * Vergleicht das Blatt von zwei Spielern unter berücksichtigung der gegegeben Kriterien:
     *  Drilling schlägt Paar, Paar schlägt komplett unterschiedliche Karten.
     *  Bei 2 Drillingen bzw. Paaren zählt das mit dem höheren Wert.
     *  Bei 2 Paaren mit gleichem Wert zählt die 3. Karte.
     *  Bei komplett unterschiedlichen Karten zählt die Summe der drei Karten.
     * @param b1 Blatt 1
     * @param b2 Blatt 2
     * @return
     */
    @Override
    public int compare(Blatt b1, Blatt b2) {
        Map.Entry<Integer,Integer> maxDuplicates1 = b1.getMaxDuplicates();
        Map.Entry<Integer,Integer> maxDuplicates2 = b2.getMaxDuplicates();

        if(maxDuplicates1.getValue() > maxDuplicates2.getValue()) return 1;
        if(maxDuplicates1.getValue() < maxDuplicates2.getValue()) return -1;
        
        if(maxDuplicates1.getKey() > maxDuplicates2.getKey()) return 1;
        if(maxDuplicates1.getKey() < maxDuplicates2.getKey()) return -1;

        if(b1.getAdditionalCard() > b2.getAdditionalCard()) return 1;
        if(b1.getAdditionalCard() < b2.getAdditionalCard()) return -1;

        return Integer.compare(b1.getSum(), b2.getSum());
    }
}
