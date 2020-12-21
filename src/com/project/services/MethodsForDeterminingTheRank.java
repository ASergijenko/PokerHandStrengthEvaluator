package com.project.services;

import com.project.Application;
import com.project.domains.Card;
import com.project.domains.FoundCombination;
import com.project.domains.Hand;

import java.util.*;
import java.util.stream.Collectors;

public class MethodsForDeterminingTheRank {

    public FoundCombination isRoyalFlush(ArrayList<Card> cards) {
        FoundCombination foundCombination = new FoundCombination();

        int royalFlashCounter = 0;
        if (isFlush(cards).isSuccess()) {
            for (Card card : isFlush(cards).getFoundCombination()) {
                if (card.getValue() <= 14 && card.getValue() >= 10) {
                    royalFlashCounter++;
                } else {
                    break;
                }
            }
        }

        if (royalFlashCounter == 5) {
            foundCombination.setResult(true);
            foundCombination.setFoundCombination(isFlush(cards).getFoundCombination());
        } else {
            foundCombination.setResult(false);
        }
        return foundCombination;
    }

    public FoundCombination isStraightFlush(ArrayList<Card> cards) {
        FoundCombination foundCombination = new FoundCombination();
        foundCombination.setResult(false);

        if (Application.typeOfPoker.equals("texas-holdem")) {
            for (int i = 6; i > -1; i--) {
                for (int j = 6; j > -1; j--) {
                    if (i != j) {
                        ArrayList<Card> tempCards = new ArrayList<>(cards);
                        if (i > j) {
                            tempCards.remove(i);
                            tempCards.remove(j);
                        } else {
                            tempCards.remove(j);
                            tempCards.remove(i);
                        }
                        if (tempCards.size() == 5) {
                            if (isFlush(tempCards).isSuccess() && isStraight(tempCards).isSuccess()) {
                                foundCombination.setResult(true);
                                foundCombination.setFoundCombination(tempCards);
                            }
                        }
                    }
                }
            }
        } else {
            if (isFlush(cards).isSuccess() && isStraight(cards).isSuccess()) {
                foundCombination.setResult(true);
                foundCombination.setFoundCombination(cards);
            }
        }
        return foundCombination;
    }

    public FoundCombination isFourOfAKind(ArrayList<Card> cards) {
        return findSimilarCardValuesInCombination(4, cards);
    }

    public FoundCombination isFullHouse(ArrayList<Card> cards) {
        FoundCombination foundCombination = new FoundCombination();
        foundCombination.setResult(false);

        if (isThreeOfAKind(cards).isSuccess()) {
            ArrayList<Card> fullHouse = new ArrayList<>(isThreeOfAKind(cards).getFoundCombination());
            ArrayList<Card> tempList = new ArrayList<>(cards);
            tempList.removeIf(card -> (card.equals(fullHouse.get(0))) || (card.equals(fullHouse.get(1))) || (card.equals(fullHouse.get(2))));

            if (isPair(tempList).isSuccess()) {
                fullHouse.addAll(isPair(tempList).getFoundCombination());
                foundCombination.setResult(true);
                foundCombination.setFoundCombination(fullHouse);
            }
        }
        return foundCombination;
    }

    public FoundCombination isFlush(ArrayList<Card> cards) {
        FoundCombination foundCombination = new FoundCombination();
        foundCombination.setResult(false);
        char largestSuit = '0';
        int cCounter = 0;
        int dCounter = 0;
        int hCounter = 0;
        int sCounter = 0;

        for (Card card : cards) {
            if (card.getSuit() == 'c') {
                cCounter++;
            } else if (card.getSuit() == 'd') {
                dCounter++;
            } else if (card.getSuit() == 'h') {
                hCounter++;
            } else {
                sCounter++;
            }
        }

        int largest = Math.max(cCounter, Math.max(dCounter, Math.max(hCounter, sCounter)));
        if (largest >= 5) {
            foundCombination.setResult(true);
            if (largest == cCounter) {
                largestSuit = 'c';
            }
            if (largest == dCounter) {
                largestSuit = 'd';
            }
            if (largest == hCounter) {
                largestSuit = 'h';
            }
            if (largest == sCounter) {
                largestSuit = 's';
            }

            char finalLargestSuit = largestSuit;
            List<Card> filteredCards = cards.stream().filter(card -> card.getSuit() == finalLargestSuit).collect(Collectors.toList());

            int maxValue = Objects.requireNonNull(filteredCards.stream().max(Comparator.comparing(Card::getValue)).orElse(null)).getValue();
            ArrayList<Card> flushCards = new ArrayList<>();
            for (int i = maxValue; i > 1; i--) {
                if (flushCards.size() == 5) {
                    break;
                } else {
                    int finalI = i;
                    Optional<Card> matchingObject = filteredCards.stream().filter(card1 -> card1.getValue() == finalI).findFirst();
                    matchingObject.ifPresent(flushCards::add);
                }
            }
            foundCombination.setFoundCombination(flushCards);
        }
        return foundCombination;
    }

    public FoundCombination isStraight(ArrayList<Card> cards) {
        FoundCombination foundCombination = new FoundCombination();
        foundCombination.setResult(false);
        ArrayList<Card> straightCards = new ArrayList<>();

        int maxValue = Objects.requireNonNull(cards.stream().max(Comparator.comparing(Card::getValue)).orElse(null)).getValue();
        //for straight A2345
        for (int i = 5; i > 1; i--) {
            if (foundCombination.isSuccess()) {
                break;
            } else {
                for (int j = 0; j < 4; j++) {
                    int finalI1 = i;
                    int finalJ = j;
                    if (cards.stream().anyMatch(card -> card.getValue() == (finalI1 - finalJ))) {
                        Card foundCard = cards.stream().filter(card -> card.getValue() == (finalI1 - finalJ)).findFirst().orElse(null);
                        straightCards.add(foundCard);
                        if (straightCards.size() == 4) {
                            if (Objects.requireNonNull(cards.stream().max(Comparator.comparing(Card::getValue)).orElse(null)).getValue() == 14) {
                                straightCards.add(cards.stream().max(Comparator.comparing(Card::getValue)).orElse(null));
                                foundCombination.setResult(true);
                                foundCombination.setFoundCombination(straightCards);
                            }
                        }
                    } else {
                        straightCards.clear();
                        break;
                    }
                }
            }
        }

        for (int i = maxValue; i > 1; i--) {
            if (foundCombination.isSuccess()) {
                break;
            } else {
                for (int j = 0; j < 5; j++) {
                    int finalI1 = i;
                    int finalJ = j;
                    if (cards.stream().anyMatch(card -> card.getValue() == (finalI1 - finalJ))) {
                        Card foundCard = cards.stream().filter(card -> card.getValue() == (finalI1 - finalJ)).findFirst().orElse(null);
                        straightCards.add(foundCard);
                        if (straightCards.size() == 5) {
                            foundCombination.setResult(true);
                            foundCombination.setFoundCombination(straightCards);
                        }
                    } else {
                        straightCards.clear();
                        break;
                    }
                }
            }
        }
        return foundCombination;
    }

    public FoundCombination isThreeOfAKind(ArrayList<Card> cards) {
        return findSimilarCardValuesInCombination(3, cards);
    }

    public FoundCombination isTwoPairs(ArrayList<Card> cards) {
        FoundCombination foundCombination = new FoundCombination();
        foundCombination.setResult(false);

        if (isPair(cards).isSuccess()) {
            ArrayList<Card> twoPairs = new ArrayList<>(isPair(cards).getFoundCombination());
            ArrayList<Card> tempList = new ArrayList<>(cards);
            tempList.removeIf(card -> (card.equals(twoPairs.get(0))) || (card.equals(twoPairs.get(1))));

            if (isPair(tempList).isSuccess()) {
                twoPairs.addAll(isPair(tempList).getFoundCombination());
                foundCombination.setResult(true);
                foundCombination.setFoundCombination(twoPairs);
            }
        }
        return foundCombination;
    }

    public FoundCombination isPair(ArrayList<Card> cards) {
        return findSimilarCardValuesInCombination(2, cards);
    }

    public ArrayList<Card> isHighCard(Hand hand) {
        ArrayList<Card> highCard = new ArrayList<>();
        highCard.add(hand.getHandCards().stream().max(Comparator.comparing(Card::getValue)).orElse(null));
        return highCard;
    }

    private FoundCombination findSimilarCardValuesInCombination(int value, ArrayList<Card> cards) {
        FoundCombination foundCombination = new FoundCombination();
        foundCombination.setResult(false);

        int quantityOfAKindCounter = 0;
        ArrayList<Card> similarValueCards = new ArrayList<>();

        outerloop:
        for (int i = 14; i > 1; i--) {
            if (foundCombination.isSuccess()) {
                break;
            } else {
                for (Card card : cards) {
                    if (card.getValue() == i) {
                        similarValueCards.add(card);
                        quantityOfAKindCounter++;
                        if (quantityOfAKindCounter == value) {
                            foundCombination.setResult(true);
                            break outerloop;
                        }
                    }
                }
            }
            quantityOfAKindCounter = 0;
            similarValueCards.clear();
        }
        foundCombination.setFoundCombination(similarValueCards);
        return foundCombination;
    }
}