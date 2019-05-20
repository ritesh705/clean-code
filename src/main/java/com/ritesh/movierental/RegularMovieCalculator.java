package com.ritesh.movierental;

class RegularMovieCalculator implements ICalculator {

    public static final int REGULAR_MOVIE_RATE = 2;
    public static final int REGULAR_MOVIE_THRESHOLD_DAYS = 2;

    @Override
    public double amount(int daysRented, double currentRentalAmount) {
        currentRentalAmount += REGULAR_MOVIE_RATE;
        if (daysRented > REGULAR_MOVIE_THRESHOLD_DAYS)
            currentRentalAmount += (daysRented - REGULAR_MOVIE_THRESHOLD_DAYS) * 1.5;
        return currentRentalAmount;
    }
}
