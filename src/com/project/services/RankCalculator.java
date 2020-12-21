package com.project.services;

import com.project.Application;
import com.project.domains.Card;
import com.project.domains.Combination;
import com.project.domains.FoundCombination;
import com.project.domains.Hand;

import java.util.ArrayList;

public class RankCalculator {

    private MethodsForDeterminingTheRank methodsForDeterminingTheRank = new MethodsForDeterminingTheRank();
    private StrengthToRankNumberConverter strengthToRankNumberConverter = new StrengthToRankNumberConverter();

    public FoundCombination calculate(Hand hand, ArrayList<Card> board) {

        ArrayList<Card> rankingData = new ArrayList<>(board);
        FoundCombination foundCombination = new FoundCombination();

        //Omaha
        if (Application.typeOfPoker.equals("omaha-holdem")) {

            int maxCombination = 0;
            int tempMaxCombination;
            int iterationCounter = 0;
            boolean maxCombinationFound = false;

            outerloop:
            for (int firstCardOfHand = 0; firstCardOfHand < 4; firstCardOfHand++) {
                for (int secondCardOfHand = 0; secondCardOfHand < 4; secondCardOfHand++) {
                    if (firstCardOfHand != secondCardOfHand) {
                        for (int firstCardOfBoard = 0; firstCardOfBoard < 5; firstCardOfBoard++) {
                            for (int secondCardOfBoard = 0; secondCardOfBoard < 5; secondCardOfBoard++) {
                                for (int thirdCardOfBoard = 0; thirdCardOfBoard < 5; thirdCardOfBoard++) {
                                    if (firstCardOfBoard != secondCardOfBoard && firstCardOfBoard != thirdCardOfBoard && secondCardOfBoard != thirdCardOfBoard) {
                                        rankingData.clear();
                                        rankingData.add(hand.getHandCards().get(firstCardOfHand));
                                        rankingData.add(hand.getHandCards().get(secondCardOfHand));
                                        rankingData.add(board.get(firstCardOfBoard));
                                        rankingData.add(board.get(secondCardOfBoard));
                                        rankingData.add(board.get(thirdCardOfBoard));
                                        foundCombination = getFoundCombination(hand, rankingData);
                                        tempMaxCombination = strengthToRankNumberConverter.convert(hand.getStrength());
                                        if (!maxCombinationFound) {
                                            if (tempMaxCombination > maxCombination) {
                                                maxCombination = tempMaxCombination;
                                            }
                                        }
                                        if (maxCombinationFound) {
                                            if (tempMaxCombination == maxCombination) {
                                                break outerloop;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                iterationCounter++;
                if (iterationCounter == 4) {
                    maxCombinationFound = true;
                    firstCardOfHand = 0;
                }
            }
            //Holdem, FiveCardDraw
        } else {
            rankingData.addAll(hand.getHandCards());
            foundCombination = getFoundCombination(hand, rankingData);
        }

        return foundCombination;
    }

    private FoundCombination getFoundCombination(Hand hand, ArrayList<Card> cards) {
        FoundCombination foundCombination = new FoundCombination();

        if (methodsForDeterminingTheRank.isRoyalFlush(cards).isSuccess()) {
            hand.setStrength(Combination.ROYAL_FLUSH);
            foundCombination.setFoundCombination(methodsForDeterminingTheRank.isRoyalFlush(cards).getFoundCombination());
        } else if (methodsForDeterminingTheRank.isStraightFlush(cards).isSuccess()) {
            hand.setStrength(Combination.STRAIGHT_FLUSH);
            foundCombination.setFoundCombination(methodsForDeterminingTheRank.isStraightFlush(cards).getFoundCombination());
        } else if (methodsForDeterminingTheRank.isFourOfAKind(cards).isSuccess()) {
            hand.setStrength(Combination.FOUR_OF_A_KIND);
            foundCombination.setFoundCombination(methodsForDeterminingTheRank.isFourOfAKind(cards).getFoundCombination());
        } else if (methodsForDeterminingTheRank.isFullHouse(cards).isSuccess()) {
            hand.setStrength(Combination.FULL_HOUSE);
            foundCombination.setFoundCombination(methodsForDeterminingTheRank.isFullHouse(cards).getFoundCombination());
        } else if (methodsForDeterminingTheRank.isFlush(cards).isSuccess()) {
            hand.setStrength(Combination.FLUSH);
            foundCombination.setFoundCombination(methodsForDeterminingTheRank.isFlush(cards).getFoundCombination());
        } else if (methodsForDeterminingTheRank.isStraight(cards).isSuccess()) {
            hand.setStrength(Combination.STRAIGHT);
            foundCombination.setFoundCombination(methodsForDeterminingTheRank.isStraight(cards).getFoundCombination());
        } else if (methodsForDeterminingTheRank.isThreeOfAKind(cards).isSuccess()) {
            hand.setStrength(Combination.THREE_OF_A_KIND);
            foundCombination.setFoundCombination(methodsForDeterminingTheRank.isThreeOfAKind(cards).getFoundCombination());
        } else if (methodsForDeterminingTheRank.isTwoPairs(cards).isSuccess()) {
            hand.setStrength(Combination.TWO_PAIRS);
            foundCombination.setFoundCombination(methodsForDeterminingTheRank.isTwoPairs(cards).getFoundCombination());
        } else if (methodsForDeterminingTheRank.isPair(cards).isSuccess()) {
            hand.setStrength(Combination.PAIR);
            foundCombination.setFoundCombination(methodsForDeterminingTheRank.isPair(cards).getFoundCombination());
        } else {
            hand.setStrength(Combination.HIGH_CARD);
            foundCombination.setFoundCombination(methodsForDeterminingTheRank.isHighCard(hand));
        }
        return foundCombination;
    }
}