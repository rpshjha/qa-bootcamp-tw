package com.vodqa.reservation.controller;

import com.vodqa.reservation.dto.ReservationUpdateRequest;
import com.vodqa.reservation.entities.Reservation;
import com.vodqa.reservation.repos.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationCheckinController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationCheckinController.class);

	@Autowired
	ReservationRepository reservationRepository;

	@RequestMapping(value ="/reservations/{id}",method = RequestMethod.GET)
	public ResponseEntity<Reservation> findReservation(@PathVariable("id") Long id) {
		LOGGER.info("Inside findReservation() for id: " + id);
		return new ResponseEntity<Reservation>(reservationRepository.findOne(id), HttpStatus.OK);

	}

	@RequestMapping(value = "/reservations", method = RequestMethod.POST)
	public ResponseEntity updateReservation(@RequestBody ReservationUpdateRequest request) {
		LOGGER.info("Inside updateReservation() for " + request);
		Reservation reservation = reservationRepository.findOne(request.getId());
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.getCheckedIn());
		LOGGER.info("Saving Reservation");
		return new ResponseEntity(reservationRepository.save(reservation), HttpStatus.OK);

	}

}
