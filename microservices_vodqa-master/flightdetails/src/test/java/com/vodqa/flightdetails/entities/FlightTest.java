package com.vodqa.flightdetails.entities;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

import java.sql.Timestamp;
import java.util.*;


public class FlightTest {

    private Flight flight;
    String flightNumber = "RK7";
    String operatingAirlines = "TarunMainiAirline";
    String departureCity = "Delhi";
    String arrivalCity = "Dusseldorf";
    Date dateOfDeparture = new Date();
    Timestamp estimatedDepartureTime = new Timestamp(2018, 10, 10, 10, 10, 10, 10);

    @Before
    public void setUp() throws Exception {
        flight = new Flight(flightNumber, operatingAirlines, departureCity, arrivalCity, dateOfDeparture, estimatedDepartureTime);
    }

    @Test
    public void getFlightNumber() {
        Assert.assertEquals(flightNumber, flight.getFlightNumber());
    }

    @Test
    public void getOperatingAirlines() {
        Assert.assertEquals(operatingAirlines, flight.getOperatingAirlines());
    }

    @Test
    public void getDepartureCity() {
        Assert.assertEquals(departureCity, flight.getDepartureCity());
    }

    @Test
    public void getArrivalCity() {
        Assert.assertEquals(arrivalCity, flight.getArrivalCity());
    }

    @Test
    public void getDateOfDeparture() {
        Assert.assertEquals(dateOfDeparture, flight.getDateOfDeparture());
    }

    @Test
    public void getEstimatedDepartureTime() {
        Assert.assertEquals(estimatedDepartureTime, flight.getEstimatedDepartureTime());
    }
}
