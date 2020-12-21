package com.project.domains;

import java.util.ArrayList;

public class FoundCombination {

    private boolean result;
    private ArrayList<Card> foundCombination;

    public FoundCombination() {
    }

    public boolean isSuccess() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public ArrayList<Card> getFoundCombination() {
        return foundCombination;
    }

    public void setFoundCombination(ArrayList<Card> foundCombination) {
        this.foundCombination = foundCombination;
    }
}