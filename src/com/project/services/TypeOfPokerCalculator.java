package com.project.services;

public class TypeOfPokerCalculator {

    public String calculate(String input) {
        String result;

        if (input.substring(0, 12).contains("texas-holdem")) {
          result = "texas-holdem";
        } else if (input.substring(0, 12).contains("omaha-holdem")) {
            result = "omaha-holdem";
        } else if (input.substring(0, 14).contains("five-card-draw")) {
            result = "five-card-draw";
        } else {
            result = "not-found";
        }
        return result;
    }
}