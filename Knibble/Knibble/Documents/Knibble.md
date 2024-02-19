# TDD Programming Assignment: Knibble

This assignment is for you to practice Test-Driven Development (TDD)

## Knibble history

When I worked for Rational Software Corporation, before they were acquired by IBM, there was a game that employees would play to determine who paid for lunch, dinner, or other business expenses that involved multiple employees. It was common for a dinner tab for 12 that included marketing and sales people to exceed $2,000. 

If an employee submitted an expense report with the receipt and just put down the reason as "lost Knibble," managers would automatically approve it. There are many stories about how new employees would be afraid to submit the expense report and their managers would let them sweat it out for a week or so before going and telling them that it was okay to submit the expense report. (Yes, it's kind of mean, but some very funny stories are based upon these things.)

Several internal research reports were published trying to identify winning strategies for Knibble.

## How to play Knibble

Knibble is played by two or more players. Each player has three coins (or chips or something players can hold in their hands). We will use "coins" to refer to the pieces. The play goes like this:

* At the beginning of the game the order of players is set. For example if Chris, Dana, and Pat are playing they decide that Chris will go first, Pat second, and Dana third.
* The game is played in rounds. Each round proceeds in the following manner.
    1. Each player takes 0, 1, 2, or 3 coins in their hand, closes their hand so no one can see how many and puts them on the table.
    2. When all players have put their hand on the table they try to guess the total number of coins in all of the hands. 
    3. Whoever is first makes a guess. In the example, the guess would have to be between 0 and 9 (three players with three coins). Pat would make the first guess.
    4. The next player in the order makes their guess. It **cannot** be the same as any other guess thus far in the round. This step is repeated until all players have made their guess.
    5. After all players have made their guess, the players open their hands to show their coins. The total is added up.
    6. If a player guessed the **exact** total then they are *out* of the game. This means that they do not lose. If no player guessed the correct number then the same players play the next round.
    7. Before the next round starts, the order shifts circularly by one. For example if in the current round, Chris went first, Pat second, and Dana third, and no one guessed the exact amount, then the order for the next round would be Pat, Dana, and then Chris. 
       - If, however Pat had guessed the correct amount, Pat would be removed for the next round, then the order for the next round would be Dana and then Chris. 
       - If Chris had guessed the correct amount, then the order for the next round would be Pat, and then Dana. 
       - If Dana had guessed the correct amount then the order for the next round would be Pat, and then Chris.
* Rounds continue until just one player is left. That player loses and must pay the bill.

## The assignment

For this assignment, you will implement a `KnibbleGame` class that a client would use to play a Knibble game. The client can be anything, a GUI that calls the game or a JUnit test that acts as the client, or some other class that creates a `KnibbleGame` and interacts with it.

You are given starting code in a zipped archive file that is an InelliJ IDEA project. 

There are several files, but the only one that you may modify in the **src** folder is **KnibbleGame.java**. You may add files if you need them for other abstractions. They should all be in the **knibble** package.

You want to make your application
- CORRECT! (This should be obvious)
- Readable
- Intentional
- Modifiable


### KnibbleGame.java

The starting `KnibbleGame` follows:

---

```
package knibble;

import java.util.List;

/**
 * Main class for managing Knibble games for the
 * TDD programming assignment.
 */
public class KnibbleGame
{
    /**
     * This is the only constructor for the game.
     * @param players the names of the players in the order 
     * of the first round of play and for when the holdings
     * and guesses are made.
     */
    public KnibbleGame(List<String> players)
    {
        // TODO: implement the constructor
    }

    public KnibbleResponse makeGuess(Guess guess) {
        // TODO: implement the game
        return null;
    }
}
```

---

You should also keep the TODO.md file to show how you approached the problem. The initial file shows you how to do this.

```
# TDD Tests and refactorings

Add to the following table

|  ID | Done | Description |
| :-: | :--: |:------------|
| T1  |      | first test  |
| R1  |      | Use the 'R' for describing a refactoring when necessary |
```

---

A video is posted on the Canvas pages that go over the starting code and this assignment. You should view that before starting the assignment.

## Submission

When you are done, export your project as a zipped archive and submit it. 