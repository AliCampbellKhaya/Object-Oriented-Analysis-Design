
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

import java.util.LinkedList;
import java.util.List;

/**
 * Main class for managing Knibble games for the
 * TDD programming assignment.
 */
public class KnibbleGame
{
    protected List<String> players;
    protected List<String> eliminatedPlayers;
    protected int totalCoins;
    protected int currentGuess;

    /**
     * This is the only constructor for the game.
     * @param players the names of the players in the order 
     * of the first round of play and for when the holdings
     * and guesses are made.
     */

    public KnibbleGame(List<String> players)
    {
        this.players = new LinkedList<>(players);
        this.eliminatedPlayers = new LinkedList<>();
        this.currentGuess = 0;
    }

    /**
     * Start a new round
     * @param totalCoins the number of coins for the round
     */
    public void newRound(int totalCoins) {
        this.totalCoins = totalCoins;
        this.currentGuess = 0;
    }

    /**
     * A player makes a guess.
     * @param guess
     * @return the response to this guess
     */
    public KnibbleResponse makeGuess(Guess guess) {
        String playerGuessName = guess.playerName();
        int playerGuessAmount = guess.guess();

        /**
         * Ensures the player is playing the game
         * Returns NO PLAYER response if the given player is not playing
         */
        if (!this.players.contains(playerGuessName)) {
            return new KnibbleResponse(ResponseCode.NO_PLAYER, String.format(ResponseMessageFormats.noPlayerMessage, playerGuessName));
        }

        /**
         * Ensures the player taking the turn is eligible
         * Returns WRONG PLAYER response if the given player is
         * playing out of order
         */
        if (!this.players.get(this.currentGuess).equals(playerGuessName)) {
            return new KnibbleResponse(ResponseCode.WRONG_PLAYER, String.format(ResponseMessageFormats.wrongPlayerMessage, playerGuessName, this.players.get(this.currentGuess)));
        }

        /**
         * Ensures a player does not attempt to play after the game is over
         * Returns GAME OVER response if the game is completed
         */
        if (this.players.size() == 1) {
            return new KnibbleResponse(ResponseCode.GAME_OVER, String.format(ResponseMessageFormats.gameOverMessage, playerGuessName));
        }

        /**
         * Ensures a player is making a guess within a valid range
         * Returns an INVALID GUESS response if the guess is not within
         * the required domain
         */
        if (playerGuessAmount < 0 || playerGuessAmount > this.totalCoins) {
            return new KnibbleResponse(ResponseCode.INVALID_GUESS, String.format(ResponseMessageFormats.invalidGuessMessage, playerGuessName, this.players.size() * 3));
        }

        /**
         * Eliminates a player from the game if they guess correctly
         * Returns a LOSER response if after the given player is eliminated
         * there is only one player left
         * Returns a EXACT GUESS response if after the given player is eliminated
         * there is more than one player left.
         */
        if (playerGuessAmount == this.totalCoins) {
            this.eliminatedPlayers.add(playerGuessName);
            this.players.remove(playerGuessName);

            // Game is over if there is only one player left
            if (this.players.size() == 1) {
                return new KnibbleResponse(ResponseCode.LOSER, String.format(ResponseMessageFormats.loserMessage, playerGuessName, this.players.get(0)));
            } else {
                return new KnibbleResponse(ResponseCode.EXACT_GUESS, String.format(ResponseMessageFormats.exactGuessMessage, playerGuessName, this.totalCoins));
            }
        }

        // Increment the player turn
        this.currentGuess = this.currentGuess + 1;

        /**
         * After every player has guessed and there is no correct guess
         * this methd will run
         * Returns a NO EXACT GUESS response if no players guessed correctly
         * in the past round
         */
        if (this.currentGuess >= this.players.size()) {
            String firstPlayer = this.players.remove(0);
            this.players.add(firstPlayer);
            return new KnibbleResponse(ResponseCode.NO_EXACT_GUESS, ResponseMessageFormats.noExactGuessMessage);
        }

        // Returns null as a response if there is no new information to give
        return null;
    }
}
