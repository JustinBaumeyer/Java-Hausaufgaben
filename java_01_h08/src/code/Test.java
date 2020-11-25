package code;

import code.implementations.Knight;
import code.implementations.Rook;

public class Test {
    public static void main(String[] args) {
// code.Test eines Turms
        Rook rook = new Rook(new Position(4,5));
        System.out.println(rook);
        rook.moveTo(new Position(4,1));
        System.out.println(rook);
        System.out.println(rook.getMoveList());
// code.Test eines Springers
        Knight knight = new Knight(new Position(5,4));
        System.out.println(knight);
        knight.moveTo(new Position(6,6)); // mitten auf dem Feld
        System.out.println(knight);
        System.out.println(knight.getMoveList());
        knight.moveTo(new Position(8,5)); // am Rand des Feldes
        System.out.println(knight);
        System.out.println(knight.getMoveList());
    }
}
