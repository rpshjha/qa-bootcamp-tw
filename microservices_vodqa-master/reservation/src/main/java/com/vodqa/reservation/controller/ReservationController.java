package com.vodqa.reservation.controller;

import com.vodqa.reservation.dto.ReservationRequest;
import com.vodqa.reservation.entities.Flight;
import com.vodqa.reservation.entities.Reservation;
import com.vodqa.reservation.services.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class ReservationController {


	@Autowired
	ReservationService reservationService;

	@Value("${flight.details.url}")
	private String flightDetailsUrl;

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

	@GetMapping("/showCompleteReservation/{flightId}")
	public ResponseEntity<Flight> showCompleteReservation(@RequestParam("flightId") Long flightId) {
		LOGGER.info("showCompleteReservation() invoked with the Flight Id: " + flightId);
		RestTemplate restTemplate = new RestTemplate();
		Flight flight=restTemplate.getForObject(flightDetailsUrl+"/findFlight/"+flightId, Flight.class);
		LOGGER.info("Flight is:" + flight);
		return new ResponseEntity(flight, HttpStatus.OK);

	}

	@RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
	public ResponseEntity completeReservation(@RequestBody ReservationRequest request) {
		LOGGER.info("completeReservation()  " + request);
		Reservation reservation;
		try {
			 reservation = reservationService.bookFlight(request);
		}
		catch(Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity(reservation, HttpStatus.CREATED);

	}

	@GetMapping("/health")
	public String healthCheck()
	{
		return "ok";
	}

}
