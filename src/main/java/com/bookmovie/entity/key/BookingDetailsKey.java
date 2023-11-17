package com.bookmovie.entity.key;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BookingDetailsKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "booking_id")
	private Long bookingId;
	
	@Column(name = "seat_id")
	private Long seatId;

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Long getSeatId() {
		return seatId;
	}

	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookingId, seatId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingDetailsKey other = (BookingDetailsKey) obj;
		return Objects.equals(bookingId, other.bookingId) && Objects.equals(seatId, other.seatId);
	}
	
}
