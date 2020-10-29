public class Goldtagespreis {
    private String datum;
    private double preis;

    /**
     *
     * @param d Datensatzzeile, die in ein Goldtagespreis Objekt geparsed werden.
     */
    public Goldtagespreis(String d) {
        String[] data = d.split("\t");
        this.datum = data[0];
        this.preis = (!data[1].equals("kein Nachweis")) ? Double.parseDouble(data[1].replace(".","").replace(",",".")) : -1; //Konvertierung in Double Format & Sonderfall Betrachtung
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    @Override
    public String toString() {
        return this.getDatum() + ": " + this.getPreis();
    }
}
