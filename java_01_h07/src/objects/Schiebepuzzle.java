package objects;

import exceptions.WrongMoveException;
import exceptions.WrongNumberException;

import java.awt.*;
import java.util.Random;
import java.util.stream.IntStream;

public class Schiebepuzzle {
    private int[][] tiles;

    /**
     * Erzeugt das Schiebepuzzle mit den Startwerten 1-15.
     */
    public Schiebepuzzle() {
        tiles = new int[4][4];
        int value = 1;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                tiles[i][j] = value++;
            }
        }
        tiles[3][3] = 0;
    }

    /**
     * Schiebt das als Parameter übergebene Plättchen an die freie Position in der direkten Nachbarschaft.
     * Falls das Plättchen nicht verschiebbar ist, wird eine WrongMoveException geworfen.
     *
     * @param tile Plättchen
     */
    public void schiebe(int tile) {
        if (istVerschiebbar(tile)) {
            Point coordinate = getCoordinates(tile);
            int row = coordinate.x, col = coordinate.y;

            Point coordinateSwap = getSwappablePoint(tile);
            assert coordinateSwap != null;
            int rowSwap = coordinateSwap.x, colSwap = coordinateSwap.y;

            tiles[rowSwap][colSwap] = tile;
            tiles[row][col] = 0;
        } else {
            throw new WrongMoveException();
        }
    }

    /**
     * Gibt zurück, ob das übergebene Plättchen verschiebbar ist.
     *
     * @param tile Plättchen
     * @return
     */
    public boolean istVerschiebbar(int tile) {
        return getSwappablePoint(tile) != null;
    }

    /**
     * Gibt die Koordinaten des leeren Plättchens in einem Point Objekt zurück, falls es in der direkten Nachbarschaft zum übergebenen Plättchen existiert.
     * Ansonsten wird null zurückgegeben.
     *
     * @param tile
     * @return
     */
    private Point getSwappablePoint(int tile) {
        Point coordinate = getCoordinates(tile);
        int row = coordinate.x, col = coordinate.y;

        for (int nextRow = Math.max(0, row - 1); nextRow <= Math.min(row + 1, 3); nextRow++) {
            for (int nextColumn = Math.max(0, col - 1); nextColumn <= Math.min(col + 1, 3); nextColumn++) {
                //Filtert das übergebene Plättchen und die diagonalen Nachbarn heraus.
                if (((Math.abs(row - nextRow) + Math.abs(col - nextColumn)) != 1)) continue;
                if (tiles[nextRow][nextColumn] == 0) {
                    return new Point(nextRow, nextColumn);
                }
            }
        }
        return null;
    }

    /**
     * Gibt die Koordinaten des übergebenen Plättchens in einem Point Objekt zurück.
     * Falls das Plättchen nicht existiert, wird eine WrongNumberException geworfen.
     *
     * @param tile
     * @return
     */
    private Point getCoordinates(int tile) {
        if (tile < 1 || tile > 15) throw new WrongNumberException();
        Point ret = new Point();
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if (tiles[i][j] == tile) {
                    ret.x = i;
                    ret.y = j;
                }
            }
        }
        return ret;
    }

    /**
     * Versucht solange die Plättchen zu mischen, bis dies 100 mal erfolgreich passiert ist.
     */
    public void mische() {
        int movesLeft = 100;
        int tryableTile;

        Random rnd = new Random();

        while (movesLeft > 0) {
            tryableTile = rnd.nextInt(14) + 1;
            if (istVerschiebbar(tryableTile)) {
                schiebe(tryableTile);
                movesLeft--;
            }
        }
    }

    /**
     * Gibt das Plättchen Array zurück.
     *
     * @return
     */
    public int[][] getTiles() {
        return tiles;
    }

    /**
     * Gibt das Schiebepuzzle in der gewünschten Formatierung zurück.
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("");
        for (int[] tileRow : tiles) {
            out.append("|");
            for (int tileEntry : tileRow) {
                out.append(tileEntry == 0 ? "  " : String.format("%2s", tileEntry)).append("|");
            }
            out.append("\n");
            IntStream.range(0, 13).forEach(i -> out.append("-"));
            out.append("\n");
        }
        return out.toString();
    }
}
