package hexaround.game;

import java.util.*;

public class Coordinate {
    private int X;
    private int Y;
    private int hashCode;

    public Coordinate(int x, int y) {
        this.X = x;
        this.Y = y;
        this.hashCode = Objects.hash(x, y);
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
