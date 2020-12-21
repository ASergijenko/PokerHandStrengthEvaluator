package com.project;

import com.project.services.TypeOfPokerCalculator;
import com.project.pokerType.FiveCardDraw;
import com.project.pokerType.Omaha;
import com.project.pokerType.Texas;
import com.project.validation.InputException;
import com.project.validation.InputValidation;

import java.util.Scanner;

public class Application {

    public static String typeOfPoker = "";

    public void execute() {

        TypeOfPokerCalculator typeOfPokerCalculator = new TypeOfPokerCalculator();
        Texas texas = new Texas();
        Omaha omaha = new Omaha();
        FiveCardDraw fiveCardDraw = new FiveCardDraw();
        InputValidation inputValidation = new InputValidation();
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {

                String input = sc.nextLine();
                inputValidation.validateFormat(input);
                typeOfPoker = typeOfPokerCalculator.calculate(input);

                if (typeOfPoker.equals("texas-holdem")) {
                        inputValidation.validateData(input.substring(13));
                        System.out.println(texas.calculate(input.substring(13)));
                    }
                if (typeOfPoker.equals("omaha-holdem")) {
                    inputValidation.validateData(input.substring(13));
                    System.out.println(omaha.calculate(input.substring(13)));
                }
                if (typeOfPoker.equals("five-card-draw")) {
                    inputValidation.validateData(input.substring(15));
                    System.out.println(fiveCardDraw.calculate(input.substring(15)));
                }
                if (typeOfPoker.equals("not-found")) {
                    throw new InputException("Incorrect type of poker");
                }

            } catch (InputException e) {
                System.err.println(e.getErrorMessage());
            }
        }
    }
}