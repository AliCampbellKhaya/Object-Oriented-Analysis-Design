package hexaround.game;

import hexaround.config.CreatureDefinition;
import hexaround.creatures.CreatureManager;
import hexaround.creatures.CreatureName;
import hexaround.creatures.CreatureProperty;
import hexaround.game.board.HexAroundBoard;
import hexaround.required.MoveResponse;
import hexaround.required.MoveResult;

import java.util.Collection;

public class HexAroundGameManager implements IHexAroundGameManager {

    private HexAroundBoard board;
    private CreatureManager creatureManager;


    public HexAroundGameManager() {

    }

    public CreatureName getCreatureAt(int x, int y) {
        return board.getCreatureAt(x, y);
    }

    public boolean hasProperty(int x, int y, CreatureProperty property) {
        CreatureName creature = board.getCreatureAt(x, y);
        return creatureManager.hasProperty(x, y, creature, property);
    }

    public boolean isOccupied(int x, int y) {
        return board.getCreatureAt(x, y) != null;
    }

    public boolean canReach(int x1, int y1, int x2, int y2) {
        CreatureName creature = board.getCreatureAt(x1, y1);
        int creatureMaxDistance = creatureManager.getCreatureMaxDistance(creature);
        int distanceToHex = ;
        // TODO: Fix
    }

    public MoveResponse placeCreature(CreatureName creature, int x, int y) {
        board.placeCreatureAt(creature, x, y);
        return new MoveResponse(MoveResult.OK, "Legal move");
    }

    public MoveResponse moveCreature(CreatureName creature, int fromX, int fromY, int toX, int toY) {
        board.moveCreatureTo(creature, fromX, fromY, toX, toY);
        return new MoveResponse(MoveResult.OK, "Legal move");
    }

    public void createBoard(HexAroundBoard board) {
        this.board = board;
    }

    public void setCreatures(Collection<CreatureDefinition> creatures) {
        this.creatureManager = new CreatureManager(creatures);
    }

}
