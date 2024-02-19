package hexaround.game.board;

import java.util.*;
import java.lang.Math;

public class Coordinate {
    private int X;
    private int Y;
    private int hashCode;

    public Coordinate(int x, int y) {
        this.X = x;
        this.Y = y;
        this.hashCode = Objects.hash(x, y);
    }

    // https://stackoverflow.com/questions/20290140/calculate-grid-distance-between-hexagons
    // https://stackoverflow.com/questions/15919783/distance-between-2-hexagons-on-hexagon-grid
    public int distanceBetweenCoords (Coordinate other) {
         int dX = Math.abs(X - other.X);
         // TODO: Fix
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        Coordinate that = (Coordinate) obj;
        return this.X == that.X && this.Y == that.Y;
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }
}
