package com.project.domains;

public class SortingStructure {

    private Hand hand;
    private Integer strength;
    private Integer highCardInCombination;
    private Integer minCardInCombination;
    private Integer highCardInHand;
    private Integer secondCardInHand;
    private Integer thirdCardInHand;
    private Integer fourthCardInHand;
    private Integer fifthCardInHand;

    private Integer priorityNumber;

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getHighCardInCombination() {
        return highCardInCombination;
    }

    public void setHighCardInCombination(Integer highCardInCombination) {
        this.highCardInCombination = highCardInCombination;
    }

    public Integer getMinCardInCombination() {
        return minCardInCombination;
    }

    public void setMinCardInCombination(Integer minCardInCombination) {
        this.minCardInCombination = minCardInCombination;
    }

    public Integer getHighCardInHand() {
        return highCardInHand;
    }

    public void setHighCardInHand(Integer highCardInHand) {
        this.highCardInHand = highCardInHand;
    }

    public Integer getSecondCardInHand() {
        return secondCardInHand;
    }

    public void setSecondCardInHand(Integer secondCardInHand) {
        this.secondCardInHand = secondCardInHand;
    }

    public Integer getThirdCardInHand() {
        return thirdCardInHand;
    }

    public void setThirdCardInHand(Integer thirdCardInHand) {
        this.thirdCardInHand = thirdCardInHand;
    }

    public Integer getFourthCardInHand() {
        return fourthCardInHand;
    }

    public void setFourthCardInHand(Integer fourthCardInHand) {
        this.fourthCardInHand = fourthCardInHand;
    }

    public Integer getFifthCardInHand() {
        return fifthCardInHand;
    }

    public void setFifthCardInHand(Integer fifthCardInHand) {
        this.fifthCardInHand = fifthCardInHand;
    }

    public Integer getPriorityNumber() {
        return priorityNumber;
    }

    public void setPriorityNumber(Integer priorityNumber) {
        this.priorityNumber = priorityNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SortingStructure that = (SortingStructure) o;

        if (hand != null ? !hand.equals(that.hand) : that.hand != null) return false;
        if (strength != null ? !strength.equals(that.strength) : that.strength != null) return false;
        if (highCardInCombination != null ? !highCardInCombination.equals(that.highCardInCombination) : that.highCardInCombination != null)
            return false;
        if (minCardInCombination != null ? !minCardInCombination.equals(that.minCardInCombination) : that.minCardInCombination != null)
            return false;
        if (highCardInHand != null ? !highCardInHand.equals(that.highCardInHand) : that.highCardInHand != null)
            return false;
        if (secondCardInHand != null ? !secondCardInHand.equals(that.secondCardInHand) : that.secondCardInHand != null)
            return false;
        if (thirdCardInHand != null ? !thirdCardInHand.equals(that.thirdCardInHand) : that.thirdCardInHand != null)
            return false;
        if (fourthCardInHand != null ? !fourthCardInHand.equals(that.fourthCardInHand) : that.fourthCardInHand != null)
            return false;
        if (fifthCardInHand != null ? !fifthCardInHand.equals(that.fifthCardInHand) : that.fifthCardInHand != null)
            return false;
        return priorityNumber != null ? priorityNumber.equals(that.priorityNumber) : that.priorityNumber == null;
    }

    @Override
    public int hashCode() {
        int result = hand != null ? hand.hashCode() : 0;
        result = 31 * result + (strength != null ? strength.hashCode() : 0);
        result = 31 * result + (highCardInCombination != null ? highCardInCombination.hashCode() : 0);
        result = 31 * result + (minCardInCombination != null ? minCardInCombination.hashCode() : 0);
        result = 31 * result + (highCardInHand != null ? highCardInHand.hashCode() : 0);
        result = 31 * result + (secondCardInHand != null ? secondCardInHand.hashCode() : 0);
        result = 31 * result + (thirdCardInHand != null ? thirdCardInHand.hashCode() : 0);
        result = 31 * result + (fourthCardInHand != null ? fourthCardInHand.hashCode() : 0);
        result = 31 * result + (fifthCardInHand != null ? fifthCardInHand.hashCode() : 0);
        result = 31 * result + (priorityNumber != null ? priorityNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SortingStructure{" +
                "hand=" + hand +
                ", strength=" + strength +
                ", highCardInCombination=" + highCardInCombination +
                ", minCardInCombination=" + minCardInCombination +
                ", highCardInHand=" + highCardInHand +
                ", secondCardInHand=" + secondCardInHand +
                ", thirdCardInHand=" + thirdCardInHand +
                ", fourthCardInHand=" + fourthCardInHand +
                ", fifthCardInHand=" + fifthCardInHand +
                ", priorityNumber=" + priorityNumber +
                '}';
    }
}