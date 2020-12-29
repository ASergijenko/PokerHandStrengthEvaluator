package com.project.services;

import com.project.domains.Card;
import com.project.domains.FoundCombination;
import com.project.domains.Hand;
import com.project.domains.SortingStructure;

import java.util.*;

public class SortingAlgorithm {

    private StrengthToRankNumberConverter strengthToRankNumberConverter = new StrengthToRankNumberConverter();
    private Map<Hand, Integer> sortedHands = new LinkedHashMap<>();

    public Map<Hand, Integer> sort(Map<Hand, FoundCombination> handsWithCombinations, ArrayList<Card> board) {
        sortedHands.clear();
        int priorityNumber = 0;

        ArrayList<SortingStructure> sortingData = new ArrayList<>();
        for (Hand hand : handsWithCombinations.keySet()) {
            SortingStructure sortingStructure1 = new SortingStructure();
            sortingStructure1.setHand(hand);
            sortingStructure1.setHighCardInCombination(Objects.requireNonNull(handsWithCombinations.get(hand).getFoundCombination().stream().max(Comparator.comparing(Card::getValue)).orElse(null)).getValue());
            sortingStructure1.setMinCardInCombination(Objects.requireNonNull(handsWithCombinations.get(hand).getFoundCombination().stream().min(Comparator.comparing(Card::getValue)).orElse(null)).getValue());
            sortingStructure1.setStrength(strengthToRankNumberConverter.convert(hand.getStrength()));
            ArrayList<Card> tempCardOfHand = new ArrayList<>(hand.getHandCards());
            tempCardOfHand.sort((card1, card2) -> card2.getValue().compareTo(card1.getValue()));

            sortingStructure1.setHighCardInHand(tempCardOfHand.get(0).getValue());
            sortingData.add(sortingStructure1);
        }

        for (SortingStructure data : sortingData) {
//Royal
            if (data.getStrength().equals(10)) {
                data.setHighCardInCombination(0);
                data.setMinCardInCombination(0);
                data.setHighCardInHand(0);
                data.setSecondCardInHand(0);
                data.setThirdCardInHand(0);
                data.setFourthCardInHand(0);
                data.setFifthCardInHand(0);
//Straights
            } else if (data.getStrength().equals(5) || data.getStrength().equals(9)) {
                data.setHighCardInHand(0);
                data.setSecondCardInHand(0);
                data.setThirdCardInHand(0);
                data.setFourthCardInHand(0);
                data.setFifthCardInHand(0);

                if (data.getHighCardInCombination().equals(14) && data.getMinCardInCombination().equals(2)) {
                    data.setMinCardInCombination(1);
                    data.setHighCardInCombination(5);
                }

//Four of a kind
            } else if (data.getStrength().equals(8)) {
                ArrayList<Card> handAllCards = new ArrayList<>();
                handAllCards.addAll(board);
                handAllCards.addAll(data.getHand().getHandCards());

                int handFourOfAKindCard = 0;
                int fourOfAKindCounter;

                for (int i = 0; i < 15; i++) {
                    fourOfAKindCounter = 0;
                    for (Card card : handAllCards) {
                        if (card.getValue() == i) {
                            fourOfAKindCounter++;
                        }
                        if (fourOfAKindCounter == 4 && handFourOfAKindCard == 0) {
                            handFourOfAKindCard = i;
                            fourOfAKindCounter = 0;
                        }
                    }
                }

                int deleted = 0;

                ArrayList<Card> handCardsWithoutCardsInCombination = new ArrayList<>(handAllCards);

                for (Card card : handAllCards) {
                    if (deleted < 4) {
                        if (card.getValue() == handFourOfAKindCard) {
                            handCardsWithoutCardsInCombination.remove(card);
                            deleted++;
                        }
                    }
                }

                ArrayList<Integer> handAdditionalValues = new ArrayList<>();
                for (Card card : handCardsWithoutCardsInCombination) {
                    handAdditionalValues.add(card.getValue());
                }

                handAdditionalValues.sort(Collections.reverseOrder());

                    data.setHighCardInCombination(handFourOfAKindCard);
                    data.setMinCardInCombination(0);
                    data.setHighCardInHand(handAdditionalValues.get(0));
                    data.setSecondCardInHand(0);
                    data.setThirdCardInHand(0);
                    data.setFourthCardInHand(0);
                    data.setFifthCardInHand(0);
//full house
            } else if (data.getStrength().equals(7)) {
                Integer threeOfAKindCard = 0;
                Integer pairCard = 0;

                ArrayList<Card> dataFullHouse = handsWithCombinations.get(data.getHand()).getFoundCombination();

                int numberOfCoincidences = 0;
                for (Card card1 : dataFullHouse) {
                    if (card1.getValue().equals(data.getHighCardInCombination())) {
                        numberOfCoincidences++;
                        if (numberOfCoincidences == 3) {
                            threeOfAKindCard = data.getHighCardInCombination();
                            pairCard = data.getMinCardInCombination();
                        } else {
                            threeOfAKindCard = data.getMinCardInCombination();
                            pairCard = data.getHighCardInCombination();
                        }
                    }
                }

                data.setHighCardInCombination(threeOfAKindCard);
                data.setMinCardInCombination(pairCard);
                data.setHighCardInHand(0);
                data.setSecondCardInHand(0);
                data.setThirdCardInHand(0);
                data.setFourthCardInHand(0);
                data.setFifthCardInHand(0);
//flush
            } else if (data.getStrength().equals(6)) {
                data.setHighCardInCombination(0);
                data.setMinCardInCombination(0);

                ArrayList<Card> dataCombinationCards = handsWithCombinations.get(data.getHand()).getFoundCombination();
                ArrayList<Integer> dataValues = new ArrayList<>();

                for (Card card : dataCombinationCards) {
                    dataValues.add(card.getValue());
                }

                dataValues.sort(Collections.reverseOrder());

                data.setHighCardInHand(dataValues.get(0));
                data.setSecondCardInHand(dataValues.get(1));
                data.setThirdCardInHand(dataValues.get(2));
                data.setFourthCardInHand(dataValues.get(3));
                data.setFifthCardInHand(dataValues.get(4));

//Three of a kind
            } else if (data.getStrength().equals(4)) {
                ArrayList<Card> handAllCards = new ArrayList<>();
                handAllCards.addAll(board);
                handAllCards.addAll(data.getHand().getHandCards());

                int handthreeOfAKindCard = 0;
                int threeOfAKindCounter;

                for (int i = 0; i < 15; i++) {
                    threeOfAKindCounter = 0;
                    for (Card card : handAllCards) {
                        if (card.getValue() == i) {
                            threeOfAKindCounter++;
                        }
                        if (threeOfAKindCounter == 3 && handthreeOfAKindCard == 0) {
                            handthreeOfAKindCard = i;
                            threeOfAKindCounter = 0;
                        }
                    }
                }

                int deleted = 0;

                ArrayList<Card> handCardsWithoutCardsInCombination = new ArrayList<>(handAllCards);

                for (Card card : handAllCards) {
                    if (deleted < 3) {
                        if (card.getValue() == handthreeOfAKindCard) {
                            handCardsWithoutCardsInCombination.remove(card);
                            deleted++;
                        }
                    }
                }

                ArrayList<Integer> handAdditionalValues = new ArrayList<>();
                for (Card card : handCardsWithoutCardsInCombination) {
                    handAdditionalValues.add(card.getValue());
                }

                handAdditionalValues.sort(Collections.reverseOrder());

                data.setHighCardInCombination(handthreeOfAKindCard);
                data.setMinCardInCombination(0);
                data.setHighCardInHand(handAdditionalValues.get(0));
                data.setSecondCardInHand(handAdditionalValues.get(1));
                data.setThirdCardInHand(0);
                data.setFourthCardInHand(0);
                data.setFifthCardInHand(0);

//two pairs
            } else if (data.getStrength().equals(3)) {
                ArrayList<Card> handAllCards = new ArrayList<>();
                handAllCards.addAll(board);
                handAllCards.addAll(data.getHand().getHandCards());

                int firstCardOfTwoPairs = 0;
                int secondCardOfTwoPairs = 0;

                int pairCounter;

                for (int i = 14; i > 0; i--) {
                    pairCounter = 0;
                    for (Card card : handAllCards) {
                        if (card.getValue() == i) {
                            pairCounter++;
                        }
                        if (pairCounter == 2 && firstCardOfTwoPairs == 0) {
                            firstCardOfTwoPairs = i;
                            pairCounter = 0;
                        }
                        if (pairCounter == 2) {
                            secondCardOfTwoPairs = i;
                        }
                    }
                    if (firstCardOfTwoPairs != 0 && secondCardOfTwoPairs != 0) {
                        break;
                    }
                }

                int firstDeleted = 0;
                int secondDeleted = 0;
                ArrayList<Card> cardsWithoutCardsInCombination = new ArrayList<>(handAllCards);

                for (Card card : handAllCards) {
                    if (firstDeleted < 2) {
                        if (card.getValue() == firstCardOfTwoPairs) {
                            cardsWithoutCardsInCombination.remove(card);
                            firstDeleted++;
                        }
                    }
                    if (secondDeleted < 2) {
                        if (card.getValue() == secondCardOfTwoPairs) {
                            cardsWithoutCardsInCombination.remove(card);
                            secondDeleted++;
                        }
                    }
                }

                ArrayList<Integer> handAdditionalValues = new ArrayList<>();
                for (Card card : cardsWithoutCardsInCombination) {
                    handAdditionalValues.add(card.getValue());
                }

                handAdditionalValues.sort(Collections.reverseOrder());

                data.setHighCardInHand(handAdditionalValues.get(0));
                data.setSecondCardInHand(0);
                data.setThirdCardInHand(0);
                data.setFourthCardInHand(0);
                data.setFifthCardInHand(0);
//pair
            } else if (data.getStrength().equals(2)) {
                ArrayList<Card> secondHandAllCards = new ArrayList<>();
                secondHandAllCards.addAll(board);
                secondHandAllCards.addAll(data.getHand().getHandCards());

                int handPairCard = 0;
                int pairCounter;

                for (int i = 0; i < 15; i++) {
                    pairCounter = 0;
                    for (Card card : secondHandAllCards) {
                        if (card.getValue() == i) {
                            pairCounter++;
                        }
                        if (pairCounter == 2 && handPairCard == 0) {
                            handPairCard = i;
                            pairCounter = 0;
                        }
                    }
                }

                int secondDeleted = 0;

                ArrayList<Card> handCardsWithoutCardsInCombination = new ArrayList<>(secondHandAllCards);

                for (Card card : secondHandAllCards) {
                    if (secondDeleted < 2) {
                        if (card.getValue() == handPairCard) {
                            handCardsWithoutCardsInCombination.remove(card);
                            secondDeleted++;
                        }
                    }
                }

                ArrayList<Integer> handAdditionalValues = new ArrayList<>();
                for (Card card : handCardsWithoutCardsInCombination) {
                    handAdditionalValues.add(card.getValue());
                }

                handAdditionalValues.sort(Collections.reverseOrder());

                data.setMinCardInCombination(0);
                data.setHighCardInHand(handAdditionalValues.get(0));
                data.setSecondCardInHand(handAdditionalValues.get(1));
                data.setThirdCardInHand(handAdditionalValues.get(2));
                data.setFourthCardInHand(0);
                data.setFifthCardInHand(0);
//highcard
            } else {
                ArrayList<Card> handAllCards = new ArrayList<>();
                handAllCards.addAll(board);
                handAllCards.addAll(data.getHand().getHandCards());

                ArrayList<Integer> handAdditionalValues = new ArrayList<>();
                for (Card card : handAllCards) {
                    handAdditionalValues.add(card.getValue());
                }

                handAdditionalValues.sort(Collections.reverseOrder());

                data.setHighCardInCombination(0);
                data.setMinCardInCombination(0);

                data.setHighCardInHand(handAdditionalValues.get(0));
                data.setSecondCardInHand(handAdditionalValues.get(1));
                data.setThirdCardInHand(handAdditionalValues.get(2));
                data.setFourthCardInHand(handAdditionalValues.get(3));
                data.setFifthCardInHand(handAdditionalValues.get(4));

            }
        }

        sortingData.sort(Comparator.comparing(SortingStructure::getStrength)
                .thenComparing(SortingStructure::getHighCardInCombination)
                .thenComparing(SortingStructure::getMinCardInCombination)
                .thenComparing(SortingStructure::getHighCardInHand)
                .thenComparing(SortingStructure::getSecondCardInHand)
                .thenComparing(SortingStructure::getThirdCardInHand)
                .thenComparing(SortingStructure::getFourthCardInHand)
                .thenComparing(SortingStructure::getFifthCardInHand));


        SortingStructure tempSortingStructure = new SortingStructure();
        int iterationCounter = 0;
        for (SortingStructure sortingStructure1 : sortingData) {
            if (iterationCounter == 0) {
                sortingStructure1.setPriorityNumber(priorityNumber);
                tempSortingStructure = sortingStructure1;
            }
            iterationCounter++;
            if (iterationCounter > 1) {
                if (!sortingStructure1.getStrength().equals(tempSortingStructure.getStrength())
                        || !sortingStructure1.getHighCardInCombination().equals(tempSortingStructure.getHighCardInCombination())
                        || !sortingStructure1.getMinCardInCombination().equals(tempSortingStructure.getMinCardInCombination())
                        || !sortingStructure1.getHighCardInHand().equals(tempSortingStructure.getHighCardInHand())
                        || !sortingStructure1.getSecondCardInHand().equals(tempSortingStructure.getSecondCardInHand())
                        || !sortingStructure1.getThirdCardInHand().equals(tempSortingStructure.getThirdCardInHand())
                        || !sortingStructure1.getFourthCardInHand().equals(tempSortingStructure.getFourthCardInHand())
                        || !sortingStructure1.getFifthCardInHand().equals(tempSortingStructure.getFifthCardInHand())) {
                    tempSortingStructure = sortingStructure1;
                    priorityNumber++;
                }
                sortingStructure1.setPriorityNumber(priorityNumber);
            }
        }

        for (SortingStructure sortingStructure1 : sortingData) {
            sortedHands.put(sortingStructure1.getHand(), sortingStructure1.getPriorityNumber());

            //test
            System.out.println(sortingStructure1.toString());
        }

        return sortedHands;
    }
}