package com.project.pokerType;

import com.project.domains.Card;
import com.project.domains.FoundCombination;
import com.project.domains.Hand;
import com.project.services.CardCharacterToCardValueConverter;
import com.project.services.RankCalculator;
import com.project.services.SortedHandsToString;
import com.project.services.SortingAlgorithm;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Omaha {

    CardCharacterToCardValueConverter cardCharacterToCardValueConverter = new CardCharacterToCardValueConverter();
    RankCalculator rankCalculator = new RankCalculator();
    SortedHandsToString sortedHandsToString = new SortedHandsToString();
    SortingAlgorithm sortingAlgorithm = new SortingAlgorithm();

    public String calculate(String input) {

        char[] characters = input.replaceAll("\\s+", "").toCharArray();

        ArrayList<Card> board = new ArrayList<>();
        ArrayList<Hand> hands = new ArrayList<>();

        int tempValue;
        char tempSuit;
        for (int i = 0; i < characters.length; i += 2) {
            tempValue = cardCharacterToCardValueConverter.convert(characters[i]);
            tempSuit = characters[i + 1];
            Card card = new Card(tempValue, tempSuit);
            if (i < 10) {
                board.add(card);
            } else {
                Hand hand = new Hand();
                ArrayList<Card> handCards = new ArrayList<>();
                hand.setHandCards(handCards);
                handCards.add(card);
                for (int k = 0; k < 3; k++) {
                    i += 2;
                    tempValue = cardCharacterToCardValueConverter.convert(characters[i]);
                    tempSuit = characters[i + 1];
                    handCards.add(new Card(tempValue, tempSuit));
                }
                hands.add(hand);
            }
        }

        Map<Hand, FoundCombination> handsWithCombinations = new LinkedHashMap<>();
        for (Hand hand : hands) {
            handsWithCombinations.put(hand, rankCalculator.calculate(hand, board));
        }

        Map<Hand, Integer> sortedHands = sortingAlgorithm.sort(handsWithCombinations, board);

        StringBuilder result = new StringBuilder();
        for (String s : sortedHandsToString.print(sortedHands)) {
            result.append(s);
        }
        return result.toString();
    }
}