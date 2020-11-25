package code;

import code.exceptions.WrongPositionException;

public class Position {
    int x,y;

    public Position(int x, int y) {
        if(!isValid(x,y)) throw new WrongPositionException();
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (getX() != position.getX()) return false;
        return getY() == position.getY();
    }

    public static boolean isValid(int x, int y) {
        return x <= 8 && x > 0 && y <= 8 && y > 0;
    }

    @Override
    public String toString() {
        return "(" + getX()+"/"+getY()+")";
    }
}
