package com.samjin.design.ood.cardgame;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int calculateValue() {
        // Implement specific game logic for calculating hand value
        int value = 0;
        int aceCount = 0;

        for (Card card : cards) {
            switch (card.getRank()) {
                case TWO: case THREE: case FOUR: case FIVE: case SIX:
                case SEVEN: case EIGHT: case NINE: case TEN:
                    value += card.getRank().ordinal() + 2;
                    break;
                case JACK: case QUEEN: case KING:
                    value += 10;
                    break;
                case ACE:
                    aceCount++;
                    value += 11;
                    break;
            }
        }

        while (aceCount > 0 && value > 21) {
            value -= 10;
            aceCount--;
        }

        return value;
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
