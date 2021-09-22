package com.vodqa.reservation.services;

import com.vodqa.reservation.dto.ReservationRequest;
import com.vodqa.reservation.entities.Flight;
import com.vodqa.reservation.entities.Passenger;
import com.vodqa.reservation.entities.Reservation;
import com.vodqa.reservation.repos.PassengerRepository;
import com.vodqa.reservation.repos.ReservationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.env.MockEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

/**
 * Created by divyar on 9/17/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ReservationServiceImplTest {

    @MockBean
    PassengerRepository passengerRepository;

    @MockBean
    ReservationRepository reservationRepository;

    @MockBean
    RestTemplate restTemplate;

    @InjectMocks
    ReservationServiceImpl reservationService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(reservationService, "flightDetailsUrl", "http://flightdetails:9090/flightdetails");
    }

    @Test
    public void bookFlight() throws Exception {
        Passenger passenger = new Passenger();
        Reservation reservation = new Reservation();
        Long flightId= 10L;
        MockEnvironment env = new MockEnvironment();
        env.setProperty("serverName", "server");

        ReservationRequest request = new ReservationRequest(flightId,"Divya","Rakhiani","divya_8989@ymail.com","9741607861","divya","1234567890123456","09/2020","728");
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setPhone(request.getPassengerPhone());
        passenger.setEmail(request.getPassengerEmail());

        reservation.setFlight_id(flightId);
        reservation.setPassenger(passenger);
        reservation.setCheckedIn(false);

        given(restTemplate.getForObject("http://flightdetails:9090/flightdetails/findFlight/10", Flight.class)).willReturn(new Flight(flightId, "A567", "A1", "Delhi", "Chandigarh", new Date(9999999), new Timestamp(888888)));
        given(passengerRepository.save(passenger)).willReturn(passenger);
        given(reservationRepository.save(reservation)).willReturn(reservation);

        Reservation actualResponse = reservationService.bookFlight(request);
        assertNotNull(actualResponse);
        assertTrue(flightId == actualResponse.getFlight_id());
    }



    @Test(expected = Exception.class)
    public void bookFlightInvalidCard() throws Exception {
        Passenger passenger = new Passenger();
        Reservation reservation = new Reservation();
        Long flightId= 10L;
        MockEnvironment env = new MockEnvironment();
        env.setProperty("serverName", "server");

        ReservationRequest request = new ReservationRequest(flightId,"Divya","Rakhiani","divya_8989@ymail.com","9741607861","divya","123456789012","09/2020","728");
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setPhone(request.getPassengerPhone());
        passenger.setEmail(request.getPassengerEmail());

        reservation.setFlight_id(flightId);
        reservation.setPassenger(passenger);
        reservation.setCheckedIn(false);

        given(restTemplate.getForObject("http://flightdetails:9090/flightdetails/findFlight/10", Flight.class)).willReturn(new Flight(flightId, "A567", "A1", "Delhi", "Chandigarh", new Date(9999999), new Timestamp(888888)));
        given(passengerRepository.save(passenger)).willReturn(passenger);
        given(reservationRepository.save(reservation)).willReturn(reservation);

        Reservation actualResponse = reservationService.bookFlight(request);

    }



    @Test(expected = Exception.class)
    public void bookFlightInvalidFirstName() throws Exception {
        Passenger passenger = new Passenger();
        Reservation reservation = new Reservation();
        Long flightId= 10L;
        MockEnvironment env = new MockEnvironment();
        env.setProperty("serverName", "server");

        ReservationRequest request = new ReservationRequest(flightId,"Di","Rakhiani","divya_8989@ymail.com","9741607861","divya","1234567890123456","09/2020","728");
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setPhone(request.getPassengerPhone());
        passenger.setEmail(request.getPassengerEmail());

        reservation.setFlight_id(flightId);
        reservation.setPassenger(passenger);
        reservation.setCheckedIn(false);

        given(restTemplate.getForObject("http://flightdetails:9090/flightdetails/findFlight/10", Flight.class)).willReturn(new Flight(flightId, "A567", "A1", "Delhi", "Chandigarh", new Date(9999999), new Timestamp(888888)));
        given(passengerRepository.save(passenger)).willReturn(passenger);
        given(reservationRepository.save(reservation)).willReturn(reservation);

        Reservation actualResponse = reservationService.bookFlight(request);

    }


    @Test(expected = Exception.class)
    public void bookFlightInvalidLastName() throws Exception {
        Passenger passenger = new Passenger();
        Reservation reservation = new Reservation();
        Long flightId= 10L;
        MockEnvironment env = new MockEnvironment();
        env.setProperty("serverName", "server");

        ReservationRequest request = new ReservationRequest(flightId,"Divya","Ra","divya_8989@ymail.com","9741607861","divya","1234567890123456","09/2020","728");
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setPhone(request.getPassengerPhone());
        passenger.setEmail(request.getPassengerEmail());

        reservation.setFlight_id(flightId);
        reservation.setPassenger(passenger);
        reservation.setCheckedIn(false);

        given(restTemplate.getForObject("http://flightdetails:9090/flightdetails/findFlight/10", Flight.class)).willReturn(new Flight(flightId, "A567", "A1", "Delhi", "Chandigarh", new Date(9999999), new Timestamp(888888)));
        given(passengerRepository.save(passenger)).willReturn(passenger);
        given(reservationRepository.save(reservation)).willReturn(reservation);

        Reservation actualResponse = reservationService.bookFlight(request);

    }


    @Test(expected = Exception.class)
    public void bookFlightInvalidPhoneNumber() throws Exception {
        Passenger passenger = new Passenger();
        Reservation reservation = new Reservation();
        Long flightId= 10L;
        MockEnvironment env = new MockEnvironment();
        env.setProperty("serverName", "server");

        ReservationRequest request = new ReservationRequest(flightId,"Divya","Rakhiani","divya_8989@ymail.com","12","divya","1234567890123456","09/2020","728");
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setPhone(request.getPassengerPhone());
        passenger.setEmail(request.getPassengerEmail());

        reservation.setFlight_id(flightId);
        reservation.setPassenger(passenger);
        reservation.setCheckedIn(false);

        given(restTemplate.getForObject("http://flightdetails:9090/flightdetails/findFlight/10", Flight.class)).willReturn(new Flight(flightId, "A567", "A1", "Delhi", "Chandigarh", new Date(9999999), new Timestamp(888888)));
        given(passengerRepository.save(passenger)).willReturn(passenger);
        given(reservationRepository.save(reservation)).willReturn(reservation);

        Reservation actualResponse = reservationService.bookFlight(request);

    }


    @Test(expected = Exception.class)
    public void bookFlightNonNumericPhoneNumber() throws Exception {
        Passenger passenger = new Passenger();
        Reservation reservation = new Reservation();
        Long flightId= 10L;
        MockEnvironment env = new MockEnvironment();
        env.setProperty("serverName", "server");

        ReservationRequest request = new ReservationRequest(flightId,"Divya","Rakhiani","divya_8989@ymail.com","12abcdefgh","divya","1234567890123456","09/2020","728");
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setPhone(request.getPassengerPhone());
        passenger.setEmail(request.getPassengerEmail());

        reservation.setFlight_id(flightId);
        reservation.setPassenger(passenger);
        reservation.setCheckedIn(false);

        given(restTemplate.getForObject("http://flightdetails:9090/flightdetails/findFlight/10", Flight.class)).willReturn(new Flight(flightId, "A567", "A1", "Delhi", "Chandigarh", new Date(9999999), new Timestamp(888888)));
        given(passengerRepository.save(passenger)).willReturn(passenger);
        given(reservationRepository.save(reservation)).willReturn(reservation);

        Reservation actualResponse = reservationService.bookFlight(request);

    }

    @Test(expected = Exception.class)
    public void bookFlightNoFlightId() throws Exception {
        Passenger passenger = new Passenger();
        Reservation reservation = new Reservation();
        Long flightId= 10L;
        MockEnvironment env = new MockEnvironment();
        env.setProperty("serverName", "server");

        ReservationRequest request = new ReservationRequest(null,"Divya","Rakhiani","divya_8989@ymail.com","9741607861","divya","1234567890123456","09/2020","728");
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setPhone(request.getPassengerPhone());
        passenger.setEmail(request.getPassengerEmail());

        reservation.setFlight_id(flightId);
        reservation.setPassenger(passenger);
        reservation.setCheckedIn(false);

        given(restTemplate.getForObject("http://flightdetails:9090/flightdetails/findFlight/10", Flight.class)).willReturn(new Flight(flightId, "A567", "A1", "Delhi", "Chandigarh", new Date(9999999), new Timestamp(888888)));
        given(passengerRepository.save(passenger)).willReturn(passenger);
        given(reservationRepository.save(reservation)).willReturn(reservation);

        Reservation actualResponse = reservationService.bookFlight(request);

    }


    @Test(expected = Exception.class)
    public void bookFlightInvalidEmail() throws Exception {
        Passenger passenger = new Passenger();
        Reservation reservation = new Reservation();
        Long flightId= 10L;
        MockEnvironment env = new MockEnvironment();
        env.setProperty("serverName", "server");

        ReservationRequest request = new ReservationRequest(null,"Divya","Rakhiani","divya_8989ymail.com","9741607861","divya","1234567890123456","09/2020","728");
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setPhone(request.getPassengerPhone());
        passenger.setEmail(request.getPassengerEmail());

        reservation.setFlight_id(flightId);
        reservation.setPassenger(passenger);
        reservation.setCheckedIn(false);

        given(restTemplate.getForObject("http://flightdetails:9090/flightdetails/findFlight/10", Flight.class)).willReturn(new Flight(flightId, "A567", "A1", "Delhi", "Chandigarh", new Date(9999999), new Timestamp(888888)));
        given(passengerRepository.save(passenger)).willReturn(passenger);
        given(reservationRepository.save(reservation)).willReturn(reservation);

        Reservation actualResponse = reservationService.bookFlight(request);

    }
}