package com.thoughtworks.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer
{
  private String name;
  private List<Rental> rentals = new ArrayList<>();

  public Customer(String name)
  {
    this.name = name;
  }

  public void addRental(Rental arg)
  {
    rentals.add(arg);
  }

  public String getName()
  {
    return name;
  }

  public String statement()
  {
    String result = statementHeader();
    result += statementBody();
    result += statementFooter();
    return result;
  }

  public String htmlStatement()
  {
    String result = htmlStatementHeader();
    result += htmlStatementBody();
    result += htmlStatementFooter();
    return result;
  }

  private String statementHeader()
  {
    return "Rental Record for " + getName() + "\n";
  }

  private String htmlStatementHeader()
  {
    return "<h1>Rental Record for <b>" + getName() + "</b></h1>";
  }

  private String statementBody()
  {
    String result = "";
    for (Rental rental : rentals)
    {
      double currentRentalAmount = rental.amount();
      //show figures for this rental
      result += "\t" + rental.getMovie().getTitle() + "\t" +
              String.valueOf(currentRentalAmount) + "\n";
    }
    return result;
  }

  private String htmlStatementBody()
  {
    String result = "";
    for (Rental rental : rentals)
    {
      double currentRentalAmount = rental.amount();
      result += rental.getMovie().getTitle()+"  "+
              String.valueOf(currentRentalAmount)+"</br>";
    }
    return result;
  }

  private String statementFooter()
  {
    int totalFrequentRenterPoints = totalFrequentRenterPoints();
    double totalAmount = totalAmount();
    String footer = "Amount owed is " + String.valueOf(totalAmount)+"\n"
            +"You earned " + String.valueOf(totalFrequentRenterPoints)
            + " frequent renter points";;
    return footer;
  }

  private String htmlStatementFooter()
  {
    int totalFrequentRenterPoints = totalFrequentRenterPoints();
    double totalAmount = totalAmount();
    String footer = "Amount owed is <b>"+String.valueOf(totalAmount)+"</b></br>"
            +"You earned <b>"+String.valueOf(totalFrequentRenterPoints)+"</b>"
            + " frequent renter points";
    return footer;
  }

  private double totalAmount()
  {
    double totalAmount = 0;
    for (Rental rental : rentals)
    {
      double currentRentalAmount = rental.amount();
      totalAmount += currentRentalAmount;
    }
    return totalAmount;
  }

  private int totalFrequentRenterPoints()
  {
    int totalFrequentRenterPoints = 0;
    for (Rental rental : rentals)
    {
      totalFrequentRenterPoints += rental.frequentRenterPointsFor();
    }
    return totalFrequentRenterPoints;
  }
}