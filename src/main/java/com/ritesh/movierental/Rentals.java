package com.ritesh.movierental;

import java.util.ArrayList;
import java.util.List;

public class Rentals
{
    private List<Rental> rentals = new ArrayList<>();

    public List<Rental> getRentals()
    {
        return rentals;
    }

    public void setRentals(List<Rental> rentals)
    {
        this.rentals = rentals;
    }

    public void add(Rental rental)
    {
        rentals.add(rental);
    }
}
