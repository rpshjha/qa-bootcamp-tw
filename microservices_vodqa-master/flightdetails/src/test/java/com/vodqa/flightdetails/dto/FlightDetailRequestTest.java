package com.vodqa.flightdetails.dto;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class FlightDetailRequestTest {

    private FlightDetailRequest flightDetailRequest;
    String from = "Delhi";
    String to = "London";
    String departureDate = new Date().toString();

    @Before
    public void setUp() throws Exception{
        flightDetailRequest = new FlightDetailRequest(from, to, departureDate);
    }

    @Test
    public void getFrom() {
        Assert.assertEquals(from, flightDetailRequest.getFrom());
    }

    @Test
    public void getTo() {
        Assert.assertEquals(to, flightDetailRequest.getTo());
    }

    @Test
    public void getDepartureDate() {
        Assert.assertEquals(departureDate, flightDetailRequest.getDepartureDate());
    }
}
