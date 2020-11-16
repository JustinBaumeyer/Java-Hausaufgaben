import java.util.Comparator;
import java.util.Map;

public class BlattVergleich implements Comparator<Blatt> {

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
