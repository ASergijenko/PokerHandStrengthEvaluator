package com.project.services;

import com.project.domains.Hand;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class SortedHandsToString {

    public ArrayList<String> print(Map<Hand, Integer> sortedHands) {

        Map<Hand, Integer> sortedAlphabetically = new LinkedHashMap<>();

        int orderNumber = 0;
        for (int i = 0; i < sortedHands.size(); i++) {
            ArrayList<Hand> tempHands = new ArrayList<>();
            for (Hand hand : sortedHands.keySet()) {
                if (sortedHands.get(hand) == orderNumber) {
                    tempHands.add(hand);
                }
            }

            if (tempHands.size() != 0) {
                tempHands.sort(Hand::compareTo);
                for (Hand hand : tempHands) {
                    sortedAlphabetically.put(hand, orderNumber);
                }
            }
            orderNumber++;
        }

        int tempValue = 1;
        int iterationCounter = 0;
        ArrayList<String> result = new ArrayList<>();

        for (Hand hand : sortedAlphabetically.keySet()) {
            if (iterationCounter == 0) {
                tempValue = sortedAlphabetically.get(hand);
                result.add(hand.toString());
            }
            iterationCounter++;
            if (iterationCounter > 1) {
                if (sortedAlphabetically.get(hand) == tempValue) {
                    result.add("=" + hand.toString());
                } else {
                    tempValue++;
                    result.add(" " + hand.toString());
                }
            }
        }
        return result;
    }
}