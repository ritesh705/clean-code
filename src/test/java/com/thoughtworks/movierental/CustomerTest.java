package com.thoughtworks.movierental;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CustomerTest
{
    @Test
    public void testNewRelease()
    {
        Customer customer = new Customer("TestCustomer");
        Movie movie = new Movie("Avengers", Movie.NEW_RELEASE);
        Rental rental = new Rental(movie, 1);
        customer.addRental(rental);
        String statement = customer.statement();
        String expected = "Rental Record for TestCustomer\n" +
                "\tAvengers\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";
        assertEquals(expected, statement);
    }

    @Test(expected=NullPointerException.class)
    public void testNoMovies()
    {
        Customer customer = new Customer("TestCustomer");
        customer.addRental(null);
        String statement = customer.statement();
        System.out.println(statement);
    }

    @Test
    public void testNewReleaseHTML()
    {
        Customer customer = new Customer("TestCustomer");
        Movie movie = new Movie("Avengers", Movie.NEW_RELEASE);
        Rental rental = new Rental(movie, 1);
        customer.addRental(rental);
        String statement = customer.htmlStatement();
        String expected = "<h1>Rental Record for <b>TestCustomer</b></h1>" +
                "Avengers  3.0</br>Amount owed is <b>3.0</b></br>" +
                "You earned <b>1</b> frequent renter points";
        assertEquals(expected, statement);
    }
}