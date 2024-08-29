package com.samjin.design.ood.cardgame;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final Deck deck;
    private final List<Player> players;

    public Game(int numberOfPlayers) {
        deck = new Deck();
        players = new ArrayList<>();

        for (int i = 1; i <= numberOfPlayers; i++) {
            players.add(new Player("Player " + i));
        }
    }

    public void startGame() {
        // Deal two cards to each player initially
        for (Player player : players) {
            player.receiveCard(deck.dealCard());
            player.receiveCard(deck.dealCard());
        }

        // Example of a simple game round
        for (Player player : players) {
            System.out.println(player);
            while (player.getHandValue() < 17) { // Simple strategy: hit until 17 or more
                player.receiveCard(deck.dealCard());
                System.out.println(player.getName() + " hits: " + player.getHandValue());
            }
        }

        determineWinner();
    }

    private void determineWinner() {
        Player winner = null;
        int highestValue = 0;

        for (Player player : players) {
            int playerValue = player.getHandValue();
            if (playerValue > highestValue && playerValue <= 21) {
                highestValue = playerValue;
                winner = player;
            }
        }

        if (winner != null) {
            System.out.println("Winner is " + winner.getName() + " with a hand value of " + highestValue);
        } else {
            System.out.println("No winner, all players busted!");
        }
    }
}
