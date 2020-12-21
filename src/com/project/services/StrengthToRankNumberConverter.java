package com.project.services;

import com.project.domains.Combination;

public class StrengthToRankNumberConverter {
    public int convert(Combination combination) {
        int number = 0;
        switch (combination) {
            case HIGH_CARD:
                number = 1;
                break;
            case PAIR:
                number = 2;
                break;
            case TWO_PAIRS:
                number = 3;
                break;
            case THREE_OF_A_KIND:
                number = 4;
                break;
            case STRAIGHT:
                number = 5;
                break;
            case FLUSH:
                number = 6;
                break;
            case FULL_HOUSE:
                number = 7;
                break;
            case FOUR_OF_A_KIND:
                number = 8;
                break;
            case STRAIGHT_FLUSH:
                number = 9;
                break;
            case ROYAL_FLUSH:
                number = 10;
                break;
        }
        return number;
    }
}