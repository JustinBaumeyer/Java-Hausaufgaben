package code;

import code.exceptions.WrongPositionException;

public class Position {
    int x,y;

    /**
     * Konstruktor der Klasse Position. Ueberprueft, ob die Uebergebene Position valide ist.
     * Falls dem nicht so ist, wird eine WrongPositionException geworfen.
     * @param x X-Wert des neuen Positionsobjekts
     * @param y Y-Wert des neuen Positionsobjekts
     */
    public Position(int x, int y) {
        if(!isValid(x,y)) throw new WrongPositionException();
        this.x = x;
        this.y = y;
    }
    /**
     * @return X-Wert des Positionsobjekts
     */
    public int getX() {
        return x;
    }

    /**
     * @return Y-Wert des Positionsobjekts
     */
    public int getY() {
        return y;
    }

    /**
     * @param o Zu ueberpruefende Position
     * @return Gibt zurueck, ob das aktuelle Positionsobjekt mit dem uebergebenen Positionsobjekt uebereinstimmt.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (getX() != position.getX()) return false;
        return getY() == position.getY();
    }

    /**
     * @param x Zu ueberpruefende X-Position
     * @param y Zu ueberpruefende Y-Position
     * @return Gibt zurueck, ob die uebergebene Position auf dem Spielfeld liegt.
     */
    public static boolean isValid(int x, int y) {
        return x <= 8 && x > 0 && y <= 8 && y > 0;
    }

    /**
     * @return Gibt die Position im geforderten Format zurueck.
     */
    @Override
    public String toString() {
        return "(" + getX()+"/"+getY()+")";
    }
}
