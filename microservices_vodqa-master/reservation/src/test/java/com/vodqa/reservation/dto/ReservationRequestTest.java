package com.vodqa.reservation.dto;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReservationRequestTest {
    private ReservationRequest reservationRequest;
    Long flightId = 1616161661L;
    String passengerFirstName="Divya";
    String passengerLastName="Rakhiani";
    String passengerEmail="divyarakhiani@testmail.com";
    String passengerPhone="9999999999";
    String nameOnTheCard="Divya";
    String cardNumber="5432-4534-2345-1569";
    String expirationDate="2018-09-12";
    String securityCode="707";

    @Before
    public void setUp() throws Exception{
        reservationRequest = new ReservationRequest(flightId, passengerFirstName, passengerLastName,
                passengerEmail, passengerPhone, nameOnTheCard, cardNumber, expirationDate,securityCode);
    }

    @Test
    public void getFlightId() {
        Assert.assertEquals(flightId, reservationRequest.getFlightId());
    }

    @Test
    public void getPassengerFirstName() {
        Assert.assertEquals(passengerFirstName, reservationRequest.getPassengerFirstName());
    }

    @Test
    public void getPassengerLastName() {
        Assert.assertEquals(passengerLastName, reservationRequest.getPassengerLastName());
    }


    @Test
    public void getPassengerEmail() {
        Assert.assertEquals(passengerEmail, reservationRequest.getPassengerEmail());
    }

    @Test
    public void getPassengerPhone() {
        Assert.assertEquals(passengerPhone, reservationRequest.getPassengerPhone());
    }

    @Test
    public void getNameOnTheCard() {
        Assert.assertEquals(nameOnTheCard, reservationRequest.getNameOnTheCard());
    }

    @Test
    public void getCardNumber() {
        Assert.assertEquals(cardNumber, reservationRequest.getCardNumber());
    }

    @Test
    public void getExpirationDate() {
        Assert.assertEquals(expirationDate, reservationRequest.getExpirationDate());
    }

    @Test
    public void getSecurityDate() {
        Assert.assertEquals(securityCode, reservationRequest.getSecurityCode());
    }


}
