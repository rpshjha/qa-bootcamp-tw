package com.vodqa.flightdetails.controllers;

import com.vodqa.flightdetails.dto.FlightDetailRequest;
import com.vodqa.flightdetails.entities.Flight;
import com.vodqa.flightdetails.repos.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class FlightController {

	@Autowired
	private FlightRepository flightRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

	@PostMapping(value = "/findFlights", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity findFlights(@RequestBody FlightDetailRequest flightDetailRequest) throws ParseException {
		String depDate = flightDetailRequest.getDepartureDate();

		DateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
		Date date = (Date) parser.parse(depDate);

		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(formatter.format(date));
		System.out.println("Inside findFlights() From:" + flightDetailRequest.getFrom() + " TO:" + flightDetailRequest.getTo() + "Departure Date: " + date);
		List<Flight> flights = flightRepository.findFlights(flightDetailRequest.getFrom(), flightDetailRequest.getTo(), date);
		LOGGER.info("Flight Found are:" + flights);
		return new ResponseEntity(flights,HttpStatus.CREATED);
	}

	@GetMapping(value = "/findAllFlights")
	public ResponseEntity findFlights() {
		List<Flight> flights = flightRepository.findAll();
		LOGGER.info("All Flights  are:" + flights);
		return new ResponseEntity(flights, HttpStatus.OK);

	}


	@GetMapping(value = "/findFlight/{flightId}")
	public ResponseEntity findFlightsByFlightid(@PathVariable("flightId") Long flightId) {
		Flight flight;
		if(flightId >10) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		flight = flightRepository.findOne(flightId);
		return new ResponseEntity(flight, HttpStatus.OK);
	}

	@GetMapping("/health")
	public String healthCheck() {
		return "ok";
	}


}
