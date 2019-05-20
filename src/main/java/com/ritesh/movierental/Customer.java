package com.ritesh.movierental;

public class Customer
{
  private String name;
  private Rentals rentals;

  public Customer(String name)
  {
    this.name = name;
  }

  public void addRental(Rental arg)
  {
    if(rentals == null)
    {
      rentals = new Rentals();
    }
    rentals.add(arg);
  }

  public String getName()
  {
    return name;
  }

  public String statement()
  {
    String result = new TextStatement().statement(name, rentals);
    return result;
  }

  public String htmlStatement()
  {
    String result = new HTMLStatement().statement(name, rentals);
    return result;
  }

  private String statementHeader()
  {
    return "Rental Record for " + getName() + "\n";
  }

  public static void main(String[] args)
  {

  }
}