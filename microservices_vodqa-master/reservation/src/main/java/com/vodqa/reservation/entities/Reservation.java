package com.vodqa.reservation.entities;

import javax.persistence.*;

@Entity
public class Reservation{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  long id;
	private Boolean checkedIn;
	private int numberOfBags;

	@OneToOne
	private Passenger passenger;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Reservation that = (Reservation) o;

		if (numberOfBags != that.numberOfBags) return false;
		if (flight_id != that.flight_id) return false;
		if (!checkedIn.equals(that.checkedIn)) return false;
		return passenger.equals(that.passenger);

	}

	@Override
	public int hashCode() {
		int result = checkedIn.hashCode();
		result = 31 * result + numberOfBags;
		result = 31 * result + passenger.hashCode();
		result = 31 * result + (int) (flight_id ^ (flight_id >>> 32));
		return result;
	}

	public long getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(long flight_id) {
		this.flight_id = flight_id;
	}

	private long flight_id;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public Boolean getCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public int getNumberOfBags() {
		return numberOfBags;
	}

	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}



}
