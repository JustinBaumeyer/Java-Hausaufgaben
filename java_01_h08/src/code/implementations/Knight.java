package code.implementations;

import code.Chessman;
import code.Position;

import java.util.ArrayList;

public class Knight extends Chessman {
    public Knight(Position pos) {
        super(pos);
    }

    @Override
    public ArrayList<Position> getMoveList() {
        ArrayList<Position> res = new ArrayList<>();
        int[] xOffsets = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] yOffsets = {1, 2, 2, 1, -1, -2, -2, -1};
        for(int i = 0; i < xOffsets.length;i++) {
            if(Position.isValid(getPosition().getX()+xOffsets[i],getPosition().getY()+yOffsets[i])) {
                res.add(new Position(getPosition().getX()+xOffsets[i],getPosition().getY()+yOffsets[i]));
            }
        }
        return res;
    }
    @Override
    public String toString() {
        return "Knight: " + this.getPosition();
    }
}
