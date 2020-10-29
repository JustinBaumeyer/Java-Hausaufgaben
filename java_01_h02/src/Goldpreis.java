import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Goldpreis {
    private ArrayList<Goldtagespreis> list;

    /**
     *
     * @param dateiname Datei mit den Goldpreisen
     * @throws FileNotFoundException
     */
    public Goldpreis(String dateiname) throws FileNotFoundException {
        list = new ArrayList<>();
        this.loadFile(new File(dateiname));
    }

    /**
     *
     * @param f Datei, die gelesen werden soll
     * @throws FileNotFoundException
     */
    private void loadFile(File f) throws FileNotFoundException {
        try (Scanner sc = new Scanner(f)) {
            while(sc.hasNextLine()) {
                this.list.add(new Goldtagespreis(sc.nextLine()));
            }
            sc.close();
        }
    }

    /**
     *
     * @param datum Das Datum, dessen Preis ausgegeben werden soll
     * @return Gibt den Preis zum angegebenen Datum zurück
     */
    public double getPreis(String datum) {
        for(Goldtagespreis gtp : list) {
            if(gtp.getDatum().equals(datum)) return gtp.getPreis();
        }
        throw new NumberFormatException("Das angegebene Datum \"" + datum + "\" ist nicht im Datensatz vorhanden!");
    }

    /**
     * Gibt alle Tage aus, an denen Gold am billigsten bzw. am
     * teuersten war
     */
    public void printMinMax() {
        double lowestPrice = list.get(0).getPreis();
        double highestPrice = lowestPrice;

        ArrayList<String> lowest = new ArrayList<>();
        ArrayList<String> highest = new ArrayList<>();

        lowest.add(list.get(0).getDatum());
        highest.add(list.get(0).getDatum());

        for(Goldtagespreis gtp : list) {
            if(gtp.getPreis() < lowestPrice && gtp.getPreis() > -1) {
                lowest.clear();
                lowestPrice = gtp.getPreis();
                lowest.add(gtp.getDatum());
            } else if(gtp.getPreis() == lowestPrice) lowest.add(gtp.getDatum());

            if(gtp.getPreis() > highestPrice) {
                highest.clear();
                highestPrice = gtp.getPreis();
                highest.add(gtp.getDatum());
            } else if(gtp.getPreis() == highestPrice) highest.add(gtp.getDatum());
        }

        System.out.println("Den niedrigsten Goldpreis von " + lowestPrice + "  gab es an folgenden Tagen:");
        System.out.println(lowest.toString().replace("[","").replace("]",""));
        System.out.println("Den hoechsten Goldpreis von " + highestPrice + "  gab es an folgenden Tagen:");
        System.out.println(highest.toString().replace("[","").replace("]",""));
    }
}
