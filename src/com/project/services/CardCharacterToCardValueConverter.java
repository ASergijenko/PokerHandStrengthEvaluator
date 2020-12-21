package com.project.services;

public class CardCharacterToCardValueConverter {

    public int convert(char character) {
        int tempValue = 0;
        switch (character) {
            case 'A':
                tempValue = 14;
                break;
            case 'K':
                tempValue = 13;
                break;
            case 'Q':
                tempValue = 12;
                break;
            case 'J':
                tempValue = 11;
                break;
            case 'T':
                tempValue = 10;
                break;
            case '9':
                tempValue = 9;
                break;
            case '8':
                tempValue = 8;
                break;
            case '7':
                tempValue = 7;
                break;
            case '6':
                tempValue = 6;
                break;
            case '5':
                tempValue = 5;
                break;
            case '4':
                tempValue = 4;
                break;
            case '3':
                tempValue = 3;
                break;
            case '2':
                tempValue = 2;
                break;
        }
        return tempValue;
    }
}