package code.implementations;

import code.Chessman;
import code.Position;

import java.util.ArrayList;

public class Rook extends Chessman {
    public Rook(Position pos) {
        super(pos);
    }

    @Override
    public ArrayList<Position> getMoveList() {
        ArrayList<Position> res = new ArrayList<>();
        for(int i = 1; i <= 8; i++) {
            Position nP1 = new Position(getPosition().getX(),i);
            Position nP2 = new Position(i,getPosition().getY());
            if(!nP1.equals(getPosition())) res.add(nP1);
            if(!nP2.equals(getPosition())) res.add(nP2);
        }
        return res;
    }

    @Override
    public String toString() {
        return "Turm: " + this.getPosition();
    }
}
