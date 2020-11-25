package code;

import code.exceptions.WrongMoveException;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Chessman {
    private Position position;

    public Chessman(Position pos) {
        this.position = pos;
    }

    public Position getPosition() {
        return position;
    }

    public void moveTo(Position pos) {
        if(canMoveTo(pos)) {
            this.position = pos;
        } else {
            throw new WrongMoveException();
        }
    }
    public boolean canMoveTo(Position pos) {
        return getMoveList().stream().anyMatch(pos::equals);
    }
    public abstract ArrayList<Position> getMoveList();
}
