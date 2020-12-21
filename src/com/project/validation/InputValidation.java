package com.project.validation;

import com.project.Application;
import com.project.domains.Card;
import com.project.services.CardCharacterToCardValueConverter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class InputValidation {

    CardCharacterToCardValueConverter cardCharacterToCardValueConverter = new CardCharacterToCardValueConverter();

    public void validateFormat(String input) {
        if (input.equals("")) {
            throw new InputException("Error: String is clear, please input data");
        }
        if (input.length() < 25) {
            throw new InputException("Error: Incorrect length of data");
        }
    }

    public void validateData(String input) {
        if (containsWrongCharacter(input)) {
            throw new InputException("Error: Incorrect symbols in input data, only 2,3,4,5,6,7,8,9,T,J,Q,K,A,c,s,d,h is allowed!");
        }
        if (Application.typeOfPoker.equals("five-card-draw")) {
            if ((input.length() + 1) % 11 != 0 || input.length() < 21) {
                throw new InputException("Incorrect quantity of cards for FIVE-CARDS-DRAW, please input data: <hand 1> <hand 2> <...> <hand N>, where <hand> = 10 symbols!");
            }
        }
        if (Application.typeOfPoker.equals("omaha-holdem")) {
            if ((input.length() - 10) % 9 != 0 || input.length() < 19) {
                throw new InputException("Incorrect quantity of cards for OMAHA, please input data: <5 board cards> <hand 1> <hand 2> <...> <hand N>, where <hand> = 8 symbols!");
            }
        }
        if (Application.typeOfPoker.equals("texas-holdem")) {
            if ((input.length() - 10) % 5 != 0 || input.length() < 15) {
                throw new InputException("Incorrect quantity of cards for HOLDEM, please input data: <5 board cards> <hand 1> <hand 2> <...> <hand N>, where <hand> = 4 symbols!");
            }
        }
        if (hasDuplicatedCards(input)) {
            throw new InputException("Error: Duplicate of card has been detected, please check input data!");
        }
    }

    private boolean hasDuplicatedCards(String input) {
        boolean result = false;
        ArrayList<Card> incomeCards = new ArrayList<>();
        char[] characters = input.replaceAll("\\s+","").toCharArray();
        for (int i = 0; i < characters.length; i += 2) {
            Card card = new Card(cardCharacterToCardValueConverter.convert(characters[i]), characters[i + 1]);
            incomeCards.add(card);
        }
        Set<Card> set = new HashSet<>(incomeCards);

        if(set.size() < incomeCards.size()) {
            result = true;
        }
        return result;
    }

    private boolean containsWrongCharacter(String input) {
        boolean result = false;

        char[] characters = input.replaceAll("\\s+","").toCharArray();

        for (int i = 0; i < characters.length; i++) {
            if (i % 2 == 0) {
                if (characters[i] != '2' && characters[i] != '3' && characters[i] != '4' && characters[i] != '5'
                        && characters[i] != '6' && characters[i] != '7' && characters[i] != '8'
                        && characters[i] != '9' && characters[i] != 'T' && characters[i] != 'J'
                        && characters[i] != 'Q' && characters[i] != 'K' && characters[i] != 'A') {
                    result = true;
                    break;
                }
            } else {
                if (characters[i] != 'c' && characters[i] != 's' && characters[i] != 'd' && characters[i] != 'h') {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}