package code;

public class PositiveNumber {
    private int value;
    char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /**
     * Speichert den uebergebenen String s als Dezimalzahl interpretiert.
     *
     * @param s Dezimalzahl
     */
    public void setDecimal(String s) {
        value = parse(s, 10);
    }

    /**
     * Speichert den uebergebenen String s als Hexadezimalzahl interpretiert.
     *
     * @param s Hexadezimalzahl
     */
    public void setHexadecimal(String s) {
        value = parse(s, 16);
    }

    /**
     * Speichert den uebergebenen String s als Binaerzahl interpretiert.
     *
     * @param s Binaerzahl
     */
    public void setBinary(String s) {
        value = parse(s, 2);
    }

    /**
     * @return Gibt die gespeicherte Zahl im Dezimalsystem zurueck. Hier ist keine Umwandlung noetig.
     */
    public String getDecimal() {
        return String.valueOf(value);
    }

    /**
     * @return Gibt die gespeicherte Zahl im Binaersystem zurueck. Hier ist eine Umwandlung noetig.
     * Die Darstellung einer Zahl im Binaersystem wird erreicht,
     * indem der Rest der Division der Zahl durch 2 solange dem Outputstring hinzugefuegt wird, bis dieser 0 ist.
     */
    public String getBinary() {
        StringBuilder out = new StringBuilder();
        int tmp = value;
        while (tmp > 0) {
            out.insert(0, tmp % 2);
            tmp /= 2;
        }
        return out.toString();
    }

    /**
     * @return Gibt die gespeicherte Zahl im Hexadezimalsystem zurueck. Hier ist eine Umwandlung noetig.
     * Die Darstellung erfolgt sehr aehnlich wie diese von Binaerzahlen, lediglich mit Basis 16 und einem hexDigits Array,
     * welche den Rest der Division in die entsprechenden Hex Zeichen umwandelt.
     */
    public String getHexadecimal() {
        StringBuilder out = new StringBuilder();
        int tmp = value;
        while (tmp > 0) {
            out.insert(0, hexDigits[tmp % 16]);
            tmp /= 16;
        }
        return out.toString();
    }

    /**
     * @param s     Uebergabestring
     * @param basis Basis von der Umgewandelt werden soll
     * @return Gibt den uebergebenen String s als int zurueck, wobei der String s als Zahl aus dem uebergebenen System interpretiert wird.
     * @throws ArithmeticException   Wird geworfen, wenn die uebergebene Zahl nicht im Wertebereich von 0 und Integer.MAX_VALUE liegt.
     * @throws NumberFormatException Wird geworfen, wenn der uebergebene String nicht zu einer Zahl im uebergenenen System passt oder keine Zahl uebergeben wurde.
     */
    private int parse(String s, int basis) {
        int i = 0;
        int length = s.length();
        int limit = Integer.MAX_VALUE;

        if (length > 0) {
            char firstChar = s.charAt(0);
            //Es wird ueberprueft, ob ein Vorzeichen angegeben ist. Da hier nur positive Zahlen erlaubt sind, wird eine Exception geworfen,
            // wenn ein anderes Vorzeichen als ein '+' vorhanden ist oder wenn nur das Vorzeichen vorhanden ist.
            if (firstChar < '0') {
                if (firstChar != '+') {
                    throw new ArithmeticException("Es sind nur positive Zahlen erlaubt!");
                }
                if (length == 1) {
                    throw new NumberFormatException("Es ist keine Zahl spezifiziert!");
                }
                i++;
            }
            int result = 0;

            while (i < length) {
                //Das aktuell zu betrachtende Zeichen wird in einen Integer umgewandelt.
                int digit = Character.digit(s.charAt(i++), basis);

                //Wenn digit kleiner als 0 ist, existiert das aktuelle Zeichen im angegebenen System nicht und somit ist keine gueltige Zahl vorhanden.
                if (digit < 0) {
                    throw new NumberFormatException("\"" + s + "\" ist keine Zahl!");
                }
                result *= basis;
                //Es wird mit dem negativen Limit gearbeitet, um einen overflow zu verhindern.
                if (result < -limit + digit) {
                    throw new NumberFormatException("Die Uebergebene Zahl ist größer als Integer.MAX_VALUE");
                }
                result -= digit;
            }
            return -result;
        } else {
            throw new NumberFormatException("Es ist keine Zahl spezifiziert!");
        }
    }

}
