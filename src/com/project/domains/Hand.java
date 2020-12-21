package com.project.domains;

import java.util.ArrayList;

public class Hand implements Comparable<Hand>{

    private ArrayList<Card> handCards;
    private Combination strength;

    public Hand() {
    }

    public ArrayList<Card> getHandCards() {
        return handCards;
    }

    public void setHandCards(ArrayList<Card> handCards) {
        this.handCards = handCards;
    }

    public Combination getStrength() {
        return strength;
    }

    public void setStrength(Combination strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        String result;
        if (handCards.size() == 2) {
            result = handCards.get(0).toString() + handCards.get(1).toString();
        } else if (handCards.size() == 4) {
            result = handCards.get(0).toString() + handCards.get(1).toString() + handCards.get(2).toString() + handCards.get(3).toString();
        } else {
            result = handCards.get(0).toString() + handCards.get(1).toString() + handCards.get(2).toString() + handCards.get(3).toString() + handCards.get(4).toString();
        }
        return result;
    }

    @Override
    public int compareTo(Hand hand) {
        //alphabetic sort
        if (handCards.get(0).getValue() > 9 && hand.getHandCards().get(0).getValue() > 9) {
            Character firstValue = handCards.get(0).toString().charAt(0);
            Character secondValue = hand.getHandCards().get(0).toString().charAt(0);

            Character firstSuit = handCards.get(0).toString().charAt(1);
            Character secondSuit = hand.getHandCards().get(0).toString().charAt(1);

            if (firstValue.compareTo(secondValue) == 0) {
                return firstSuit.compareTo(secondSuit);
            } else {
                return firstValue - secondValue;
            }
        } else {
            int firstValue = handCards.get(0).getValue();
            int secondValue = hand.getHandCards().get(0).getValue();

            if (firstValue - secondValue == 0) {
                int firstSuit = suitToNumber(handCards.get(0).getSuit());
                int secondSuit = suitToNumber(hand.getHandCards().get(0).getSuit());
                return firstSuit - secondSuit;
            } else {
                return firstValue - secondValue;
            }
        }
    }

    private int suitToNumber(char suit) {
        int result = 0;
        switch (suit) {
            case 'c':
                result = 1;
                break;
            case 'd':
                result = 2;
                break;
            case 'h':
                result = 3;
                break;
            case 's':
                result = 4;
                break;
        }
        return result;
    }
}