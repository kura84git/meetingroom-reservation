package com.kura.example.domain.service.reservation;

public class UnavaliableReservationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnavaliableReservationException(String message) {
		super(message);
	}
}
