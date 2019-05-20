package com.ritesh.movierental;

class NewMovieCalculator implements ICalculator {
    @Override
    public double amount(int daysRented, double currentRentalAmount) {
        currentRentalAmount += daysRented * 3;
        return currentRentalAmount;
    }
}
