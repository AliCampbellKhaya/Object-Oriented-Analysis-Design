/*
 * ******************************************************************************
 *  This files was developed for CS4233: Object-Oriented Analysis & Design.
 *  The course was taken at Worcester Polytechnic Institute.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  * Copyright ©2016-2024 Gary F. Pollice
 *  *******************************************************************************
 *
 */

package knibble;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class KnibbleTests {
    KnibbleGame game;
    TestKnibbleGame testGame;

    @Test
    void createTwoPlayerGame() {
        game = testGame = new TestKnibbleGame(Arrays.asList(new String[]{"a", "b"}));
        assertNotNull(game);
        assertNotNull(testGame);
    }

    @Test
    void storeTwoPlayers() {
        game = testGame = new TestKnibbleGame(Arrays.asList(new String[]{"A", "B"}));

        List<String> players = testGame.getPlayers();
        String p1 = players.get(0);
        String p2 = players.get(1);

        assertEquals("A", p1);
        assertEquals("B", p2);
    }

    @Test
    void storeTotalCoins() {
        game = testGame = new TestKnibbleGame(Arrays.asList(new String[]{"A", "B"}));
        testGame.newRound(5);

        int totalCoins = testGame.getTotalCoins();

        assertEquals(5, totalCoins);
    }

    @Test
    void noPlayerResponse() {
        game = new TestKnibbleGame(Arrays.asList(new String[]{"A", "B"}));
        game.newRound(5);

        KnibbleResponse response = game.makeGuess(new Guess("C", 5));
        KnibbleResponse expectedResponse = new KnibbleResponse(ResponseCode.NO_PLAYER, String.format(ResponseMessageFormats.noPlayerMessage, "C"));

        assertEquals(expectedResponse, response);
    }

    @Test
    void wrongPlayerResponse() {
        game = new TestKnibbleGame(Arrays.asList(new String[]{"A", "B"}));
        game.newRound(5);

        KnibbleResponse response = game.makeGuess(new Guess("B", 5));
        KnibbleResponse expectedResponse = new KnibbleResponse(ResponseCode.WRONG_PLAYER, String.format(ResponseMessageFormats.wrongPlayerMessage, "B", "A"));

        assertEquals(expectedResponse, response);
    }

    @Test
    void invalidGuessResponseMax() {
        game = new TestKnibbleGame(Arrays.asList(new String[]{"A", "B"}));
        game.newRound(5);

        KnibbleResponse response = game.makeGuess(new Guess("A", 8));
        KnibbleResponse expectedResponse = new KnibbleResponse(ResponseCode.INVALID_GUESS, String.format(ResponseMessageFormats.invalidGuessMessage, "A", 6));

        assertEquals(expectedResponse, response);

        // Search for out of domain both ways
        response = game.makeGuess(new Guess("A", -3));
        expectedResponse = new KnibbleResponse(ResponseCode.INVALID_GUESS, String.format(ResponseMessageFormats.invalidGuessMessage, "A", 6));

        assertEquals(expectedResponse, response);
    }

    @Test
    void exactGuessResponse() {
        game = new TestKnibbleGame(Arrays.asList(new String[]{"A", "B", "C"}));
        game.newRound(5);

        KnibbleResponse response = game.makeGuess(new Guess("A", 5));
        KnibbleResponse expectedResponse = new KnibbleResponse(ResponseCode.EXACT_GUESS, String.format(ResponseMessageFormats.exactGuessMessage, "A", 5));

        assertEquals(expectedResponse, response);
    }

    @Test
    void noExactGuessResponse() {
        game = new TestKnibbleGame(Arrays.asList(new String[]{"A", "B"}));
        game.newRound(5);

        game.makeGuess(new Guess("A", 1));
        KnibbleResponse response = game.makeGuess(new Guess("B", 2));
        KnibbleResponse expectedResponse = new KnibbleResponse(ResponseCode.NO_EXACT_GUESS, String.format(ResponseMessageFormats.noExactGuessMessage));

        assertEquals(expectedResponse, response);
    }

    @Test
    void loserResponse() {
        game = new TestKnibbleGame(Arrays.asList(new String[]{"A", "B", "C"}));
        game.newRound(5);

        game.makeGuess(new Guess("A", 5));
        game.newRound(3);

        KnibbleResponse response = game.makeGuess(new Guess("B", 3));
        KnibbleResponse expectedResponse = new KnibbleResponse(ResponseCode.LOSER, String.format(ResponseMessageFormats.loserMessage, "B", "C"));

        assertEquals(expectedResponse, response);
    }

    @Test
    void gameOverResponse() {
        game = new TestKnibbleGame(Arrays.asList(new String[]{"A", "B", "C"}));
        game.newRound(5);

        game.makeGuess(new Guess("A", 5));
        game.newRound(3);

        game.makeGuess(new Guess("B", 3));

        game.newRound(2);
        KnibbleResponse response = game.makeGuess(new Guess("C", 2));
        KnibbleResponse expectedResponse = new KnibbleResponse(ResponseCode.GAME_OVER, String.format(ResponseMessageFormats.gameOverMessage, "C"));

        assertEquals(expectedResponse, response);
    }
}
