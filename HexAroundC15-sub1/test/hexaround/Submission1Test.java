package hexaround;

import hexaround.creatures.CreatureProperty;
import hexaround.game.*;
import org.junit.jupiter.api.*;

import java.io.*;

import static hexaround.creatures.CreatureName.*;
import static org.junit.jupiter.api.Assertions.*;

public class Submission1Test {
    HexAroundFirstSubmission gameManager = null;

    @Test
    void placeAndGetCreature() throws IOException {
        String hgcFile = "testConfigurations/FirstConfiguration.hgc";
        IHexAround1 gameManager =
            HexAroundGameBuilder.buildGameManager(
                "testConfigurations/FirstConfiguration.hgc");
        gameManager.placeCreature(GRASSHOPPER, 5, 42);
        assertEquals(GRASSHOPPER,gameManager.getCreatureAt(5, 42));
    }

    @Test
    void creatureHasProperty() throws IOException {
        IHexAround1 gameManager =
                HexAroundGameBuilder.buildGameManager(
                        "testConfigurations/FirstConfiguration.hgc");
        gameManager.placeCreature(GRASSHOPPER, 0, 0);
        assertTrue(gameManager.hasProperty(0, 0, CreatureProperty.JUMPING));
    }

    @Test
    void tileIsOccupied() throws IOException {
        IHexAround1 gameManager =
                HexAroundGameBuilder.buildGameManager(
                        "testConfigurations/FirstConfiguration.hgc");
        gameManager.placeCreature(GRASSHOPPER, 0, 0);
        assertTrue(gameManager.isOccupied(0, 0));
    }

    @Test
    void creatureCanReach() throws IOException {
        IHexAround1 gameManager =
                HexAroundGameBuilder.buildGameManager(
                        "testConfigurations/FirstConfiguration.hgc");
        gameManager.placeCreature(GRASSHOPPER, 0, 0);
        assertTrue(gameManager.canReach(0, 0, 1, 1));
    }
}
