package objects;

import exceptions.WrongMoveException;
import exceptions.WrongNumberException;

import java.awt.*;
import java.util.Random;
import java.util.stream.IntStream;

public class Schiebepuzzle {
    private int[][] tiles;
    public Schiebepuzzle() {
        tiles = new int[4][4];
        int value = 1;
        for(int i = 0; i < tiles.length;i++) {
            for(int j = 0; j < tiles[i].length;j++) {
                tiles[i][j] = value++;
            }
        }
        tiles[3][3] = 0;
    }
    public void schiebe(int tile) {
        if(istVerschiebbar(tile)) {
            Point coordinate = getCoordinates(tile);
            int row = coordinate.x, col = coordinate.y;

            Point coordinateSwap = getSwappablePoint(tile);
            int rowSwap = coordinateSwap.x, colSwap = coordinateSwap.y;

            tiles[rowSwap][colSwap] = tile;
            tiles[row][col] = 0;
        } else {
            throw new WrongMoveException();
        }
    }
    public boolean istVerschiebbar(int tile) {
        return getSwappablePoint(tile) != null;
    }
    private Point getSwappablePoint(int tile) {
        Point coordinate = getCoordinates(tile);
        int row = coordinate.x, col = coordinate.y;

        for(int nextRow=Math.max(0,row-1); nextRow<=Math.min(row+1,3);nextRow++) {
            for(int nextColumn=Math.max(0,col-1); nextColumn<=Math.min(col+1,3);nextColumn++) {
                if(nextRow == row && nextColumn==col || ((Math.abs(row-nextRow) + Math.abs(col-nextColumn)) > 1)) continue;
                if(tiles[nextRow][nextColumn] == 0) {
                    return new Point(nextRow,nextColumn);
                }
            }
        }
        return null;
    }
    private Point getCoordinates(int tile) {
        if(tile < 1 || tile > 15) throw new WrongNumberException();
        Point ret = new Point();
        for(int i = 0; i < tiles.length;i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if(tiles[i][j] == tile) {
                    ret.x = i;
                    ret.y= j;
                }
            }
        }
        return ret;
    }
    public void mische() {
        int movesLeft = 100;
        Random rnd = new Random();
        while(movesLeft > 0) {
            int tryableTile = rnd.nextInt(14)+1;
            if(istVerschiebbar(tryableTile)) {
                schiebe(tryableTile);
                movesLeft--;
            }
        }
    }

    public int[][] getTiles() {
        return tiles;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("");
        for(int[] tileRow : tiles) {
            out.append("|");
            for(int tileEntry : tileRow) {
                out.append(tileEntry==0 ? "  ":String.format("%2s",tileEntry)).append("|");
            }
            out.append("\n");
            IntStream.range(0,13).forEach(i -> out.append("-"));
            out.append("\n");
        }
        return out.toString();
    }
}
