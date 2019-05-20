package com.thoughtworks.movierental;

class ChildrenMovieCalculator implements ICalculator {
    @Override
    public double amount(int daysRented, double currentRentalAmount) {
        currentRentalAmount += 1.5;
        if (daysRented > 3)
            currentRentalAmount += (daysRented - 3) * 1.5;
        return currentRentalAmount;
    }
}
