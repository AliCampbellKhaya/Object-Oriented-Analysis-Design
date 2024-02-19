package hexaround.game.board;

import hexaround.creatures.CreatureName;

import java.util.*;

public class HexAroundBoard {
    private Map<Coordinate, CreatureName> board;

    public HexAroundBoard() {
        this.board = new HashMap<>();
    }

    public CreatureName getCreatureAt(int x, int y) {
        return board.get(new Coordinate(x, y));
    }

    public void placeCreatureAt(CreatureName creature, int x, int y) {
        board.put(new Coordinate(x, y), creature);
    }

    public void moveCreatureTo(CreatureName creature, int fromX, int fromY, int toX, int toY) {
        board.put(new Coordinate(toX, toY), creature);
        board.remove(new Coordinate(fromX, fromY));
    }
}
