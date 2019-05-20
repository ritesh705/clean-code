package com.ritesh.movierental;

public class Rental {

  private int daysRented;
  Movie movie;

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

  public double amount()
  {
    return movie.amount(this.daysRented);
  }

  public int frequentRenterPoints(int daysRented)
  {
    return movie.frequentRenterPoints(daysRented);
  }
}