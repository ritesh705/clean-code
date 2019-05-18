package com.thoughtworks.movierental;

public class Rental {

  private int daysRented;
  private Movie movie;

  public Rental(Movie movie, int daysRented){
    this.movie = movie;
    this.daysRented = daysRented;
  }

  public int getDaysRented() {
    return daysRented;
  }

  public Movie getMovie() {
    return movie;
  }

  double amount()
  {
    double currentRentalAmount = 0;
    //determine amounts for each line
    switch (getMovie().getPriceCode())
    {
      case Movie.REGULAR:
        currentRentalAmount += 2;
        if (daysRented > 2)
          currentRentalAmount += (daysRented - 2) * 1.5;
        break;
      case Movie.NEW_RELEASE:
        currentRentalAmount += daysRented * 3;
        break;
      case Movie.CHILDRENS:
        currentRentalAmount += 1.5;
        if (daysRented > 3)
          currentRentalAmount += (daysRented - 3) * 1.5;
        break;
    }
    return currentRentalAmount;
  }

  int frequentRenterPointsFor()
  {
    int frequentRenterPoints = 1;
    frequentRenterPoints = frequentRenterPoints(frequentRenterPoints);
    return frequentRenterPoints;
  }

  private int frequentRenterPoints(int frequentRenterPoints) {
    if (isBonusApplicable())
      frequentRenterPoints++;
    return frequentRenterPoints;
  }

  boolean isBonusApplicable()
  {
    return movie.isNewRelease(this)
            && this.getDaysRented() > 1;
  }

}