package code;

import code.exceptions.WrongMoveException;

import java.util.ArrayList;
public abstract class Chessman {
    /**
     * Position der Schachfigur.
     */
    private Position position;

    /**
     * Konstruktor der Schachfigur
     * @param pos Position der Figur
     */
    public Chessman(Position pos) {
        this.position = pos;
    }

    /**
     * @return Gibt die Position der Schachfigur zurueck.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Bewegt die Schachfigur, falls moeglich, auf die uebergebene Position.
     * Falls dies nicht moeglich ist, wird eine WrongMoveException geworfen.
     * @param pos Neue Position
     */
    public void moveTo(Position pos) {
        if(canMoveTo(pos)) {
            this.position = pos;
        } else {
            throw new WrongMoveException();
        }
    }

    /**
     * Ueberpruft, ob die uebergebene Position von der Schachfigur erreichbar ist.
     * Dies wird ueberprueft, indem geschaut wird, ob die uebergebene Position in der Liste der
     * moeglichen Positionen enthalten ist.
     * @param pos
     * @return
     */
    public boolean canMoveTo(Position pos) {
        return getMoveList().stream().anyMatch(pos::equals);
    }

    /**
     * Abstrakte Methode, die Implementiert werden muss.
     * Gibt eine Liste von moeglichen Positionen zurueck, die im naechsten Zug erreicht werden koennen.
     * @return
     */
    public abstract ArrayList<Position> getMoveList();
}
