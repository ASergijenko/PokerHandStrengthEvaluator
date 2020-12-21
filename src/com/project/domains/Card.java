package com.project.domains;

import java.util.Objects;

public class Card {

    private Integer value;
    private char suit;

    public Card(int value, char suit) {
        this.value = value;
        this.suit = suit;
    }

    public Integer getValue() {
        return value;
    }

    public char getSuit() {
        return suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (suit != card.suit) return false;
        return Objects.equals(value, card.value);
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (int) suit;
        return result;
    }

    private String convertValueToCard(Integer cardValue) {
        String card;

        if (cardValue > 1 && cardValue < 10) {
            card = cardValue.toString();
        } else if (cardValue == 10) {
            card = "T";
        } else if (cardValue == 11) {
            card = "J";
        } else if (cardValue == 12) {
            card = "Q";
        } else if (cardValue == 13) {
            card = "K";
        } else {
            card = "A";
        }
        return card;
    }

    @Override
    public String toString() {
        return convertValueToCard(value) + suit;
    }
}