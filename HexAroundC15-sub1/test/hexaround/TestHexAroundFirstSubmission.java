package hexaround;

import hexaround.config.*;
import hexaround.creatures.CreatureManager;
import hexaround.creatures.CreatureName;
import hexaround.creatures.CreatureProperty;
import hexaround.game.*;
import hexaround.required.MoveResponse;

import java.util.*;

public class TestHexAroundFirstSubmission extends HexAroundFirstSubmission {

    public TestHexAroundFirstSubmission(Collection<CreatureDefinition> creatures) {
        super(creatures);
    }

    public CreatureName getCreatureAt(int x, int y) {
        return super.getCreatureAt(x, y);
    }

    public boolean hasProperty(int x, int y, CreatureProperty property) {
        return super.hasProperty(x, y, property);
    }

    public boolean isOccupied(int x, int y) {
        return super.isOccupied(x, y);
    }

    public boolean canReach(int x1, int y1, int x2, int y2) {
        return super.canReach(x1, y1, x2, y2);
    }

    public MoveResponse placeCreature(CreatureName creature, int x, int y) {
        return super.placeCreature(creature, x, y);
    }

    public MoveResponse moveCreature(CreatureName creature, int fromX, int fromY, int toX, int toY) {
        return super.moveCreature(creature, fromX, fromY, toX, toY);
    }

    public Map<Coordinate, CreatureName> getBoard() { return board; }

    public CreatureManager getCreatureManager() { return creatureManager; }
}
