package knibble;

import java.util.*;

public class TestKnibbleGame extends KnibbleGame{

    public TestKnibbleGame(List<String> players) {
        super(players);
    }

    public void newRound(int totalCoins) { super.newRound(totalCoins); }

    public List<String> getPlayers() {
        return players;
    }

    public int getTotalCoins() { return totalCoins; }
}
