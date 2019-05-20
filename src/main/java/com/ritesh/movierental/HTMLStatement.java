package com.ritesh.movierental;

public class HTMLStatement
{
    public String statement(String name, Rentals rentals)
    {
        String result = statementHeader(name);
        result += statementBody(rentals);
        result += statementFooter(rentals);
        return result;
    }

    private String statementHeader(String name)
    {
        return "<h1>Rental Record for <b>" + name + "</b></h1>";
    }

    private String statementBody(Rentals rentals)
    {
        String result = "";
        for (Rental rental : rentals.getRentals())
        {
            double currentRentalAmount = rental.amount();
            result += rental.getMovie().getTitle()+"  "+
                    String.valueOf(currentRentalAmount)+"</br>";
        }
        return result;
    }

    private String statementFooter(Rentals rentals)
    {
        int totalFrequentRenterPoints = totalFrequentRenterPoints(rentals);
        double totalAmount = totalAmount(rentals);
        String footer = "Amount owed is <b>"+String.valueOf(totalAmount)+"</b></br>"
                +"You earned <b>"+String.valueOf(totalFrequentRenterPoints)+"</b>"
                + " frequent renter points";

        return footer;
    }

    protected double totalAmount(Rentals rentals)
    {
        double totalAmount = 0;
        for (Rental rental : rentals.getRentals())
        {
            double currentRentalAmount = rental.amount();
            totalAmount += currentRentalAmount;
        }
        return totalAmount;
    }

    protected int totalFrequentRenterPoints(Rentals rentals)
    {
        int totalFrequentRenterPoints = 0;
        for (Rental rental : rentals.getRentals())
        {
            totalFrequentRenterPoints += rental.frequentRenterPoints(rental.getDaysRented());
        }
        return totalFrequentRenterPoints;
    }
}
