package com.vodqa.reservation.services;

import com.vodqa.reservation.dto.ReservationRequest;
import com.vodqa.reservation.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request) throws Exception;

}
