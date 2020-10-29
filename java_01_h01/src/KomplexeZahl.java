public class KomplexeZahl {
    private double realPart;
    private double imaginaryPart;

    /**
     *
     * @param r Realteil
     * @param i Imaginärteil
     */
    public KomplexeZahl(double r, double i) {
        this.setRealPart(r);
        this.setImaginaryPart(i);
    }

    /**
     *
     * @param c Komplexe Zahl
     */
    public KomplexeZahl(KomplexeZahl c) {
        realPart = c.realPart;
        imaginaryPart = c.imaginaryPart;
    }

    /**
     *
     * @param k Komplexe Zahl
     */
    public void addiere(KomplexeZahl k) {
        this.realPart += k.realPart;
        this.imaginaryPart += k.imaginaryPart;
    }

    /**
     *
     * @param k Komplexe Zahl
     */
    public void multipliziere(KomplexeZahl k) {
        double oldRealPart = this.realPart;
        double oldimaginaryPart = this.imaginaryPart;
        this.realPart = oldRealPart * k.realPart - oldimaginaryPart * k.imaginaryPart;
        this.imaginaryPart = oldRealPart * k.imaginaryPart + oldimaginaryPart * k.realPart;
    }

    /**
     *
     * @return Gibt den Betrag der Komplexen Zahl zurück
     */
    public double getBetrag() {
        return Math.sqrt(realPart * realPart + imaginaryPart * imaginaryPart);
    }

    /**
     * Konjugiert die Komplexe Zahl
     */
    public void konjugiertKomplex() {
        this.imaginaryPart *= -1;
    }

    /**
     *
     * @return gibt eine neue Komplexe Zahl zurück, welche konjugiert ist
     */
    public KomplexeZahl getKonjugiertKomplex() {
        return new KomplexeZahl(this.getRealPart(), -this.getImaginaryPart());
    }

    /**
     *
     * @return Gibt ein Array der Länge zwei zurück, worin die beiden Lösungen der Quadratwurzel der Komplexen Zahl enthalten sind.
     */
    public KomplexeZahl[] getWurzel() {
        KomplexeZahl[] res = new KomplexeZahl[2];

        double rl = Math.sqrt((getBetrag() + getRealPart())/2);
        double img = Math.sqrt((getBetrag() - getRealPart())/2);

        KomplexeZahl r = new KomplexeZahl(rl,img);
        KomplexeZahl r2 = r.getKonjugiertKomplex();
        r2.setRealPart(-1*r2.getRealPart());

        res[0] = r;
        res[1] = r2;
        return res;
    }

    /**
     *
     * @param z Komplexe Zahl
     * @return Gibt eine neue Komplexe Zahl, welche die Summe von Parameter z und der aktuellen Zahl repräsentiert, zurück
     */
    public KomplexeZahl getSumme(KomplexeZahl z) {
        KomplexeZahl res = new KomplexeZahl(this);
        res.addiere(z);
        return res;
    }

    /**
     *
     * @param z Komplexe Zahl
     * @return Gibt eine neue Komplexe Zahl, welche das Produkt von Parameter z und der aktuellen Zahl repräsentiert, zurück
     */
    public KomplexeZahl getProdukt(KomplexeZahl z) {
        KomplexeZahl res = new KomplexeZahl(this);
        res.multipliziere(z);
        return res;
    }


    /**
     *
     * @param v Realteil neu setzen
     */
    public void setRealPart(double v) {
        realPart = v;
    }

    /**
     *
     * @param v Imaginärteil neu setzen
     */
    public void setImaginaryPart(double v) {
        imaginaryPart = v;
    }

    /**
     *
     * @return Realteil der Komplexen Zahl
     */
    public double getRealPart() {
        return realPart;
    }

    /**
     *
     * @return Imaginärteil der Komplexen Zahl
     */
    public double getImaginaryPart() {
        return imaginaryPart;
    }

    /**
     *
     * @return Komplexe Zahl als String
     */
    @Override
    public String toString() {
        String res = String.valueOf(getRealPart());
        if(imaginaryPart != 0) {
            if(imaginaryPart == 1) {
                res += " + i";
            } else {
                res += (imaginaryPart >= 0 ? " + ": " - ") + Math.abs(imaginaryPart) + "i";
            }
        }
        return res;
    }
}
