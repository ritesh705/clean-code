package com.thoughtworks.movierental;

public class TextStatement
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
        return "Rental Record for " + name + "\n";
    }

    private String statementBody(Rentals rentals)
    {
        String result = "";
        for (Rental rental : rentals.getRentals())
        {
            double currentRentalAmount = rental.amount();
            result += "\t" + rental.getMovie().getTitle() + "\t" +
                    String.valueOf(currentRentalAmount) + "\n";
        }
        return result;
    }

    private String statementFooter(Rentals rentals)
    {
        int totalFrequentRenterPoints = totalFrequentRenterPoints(rentals);
        double totalAmount = totalAmount(rentals);
        String footer = "Amount owed is " + String.valueOf(totalAmount)+"\n"
                +"You earned " + String.valueOf(totalFrequentRenterPoints)
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

