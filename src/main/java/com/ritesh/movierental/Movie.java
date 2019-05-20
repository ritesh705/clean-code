package com.ritesh.movierental;


public class Movie
{
  public static final int CHILDRENS = 2;
  public static final int REGULAR = 0;
  public static final int NEW_RELEASE = 1;
  public static final int REGULAR_MOVIE_RATE = 2;
  public static final int REGULAR_MOVIE_THRESHOLD_DAYS = 2;

  private String title;
  private int priceCode;

  public Movie(String title, int priceCode)
  {
    this.title = title;
    this.priceCode = priceCode;
  }

  public int getPriceCode()
  {
    return priceCode;
  }

  public void setPriceCode(int arg) {
    priceCode = arg;
  }

  public String getTitle()
  {
    return title;
  }


  boolean isNewRelease()
  {
    return this.getPriceCode() == NEW_RELEASE;
  }

  double amount(int daysRented)
  {
    double currentRentalAmount = 0;
    switch (this.getPriceCode())
    {
      case REGULAR:
        currentRentalAmount = new RegularMovieCalculator().amount(daysRented, currentRentalAmount);
        break;
      case NEW_RELEASE:
        currentRentalAmount = new NewMovieCalculator().amount(daysRented, currentRentalAmount);
        break;
      case CHILDRENS:
        currentRentalAmount = new ChildrenMovieCalculator().amount(daysRented, currentRentalAmount);
        break;
    }
    return currentRentalAmount;
  }

  boolean isBonusApplicable(int daysRented)
  {
    return isNewRelease()
            && daysRented > 1;
  }

  public int frequentRenterPoints(int daysRented)
  {
    int frequentRenterPoints = 1;
    if (isBonusApplicable(daysRented))
      frequentRenterPoints++;
    return frequentRenterPoints;
  }
}
