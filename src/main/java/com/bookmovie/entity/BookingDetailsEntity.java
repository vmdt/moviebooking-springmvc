package com.bookmovie.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.bookmovie.entity.key.BookingDetailsKey;

@Entity
@Table(name = "booking_details")
public class BookingDetailsEntity {
	@EmbeddedId
	private BookingDetailsKey id = new BookingDetailsKey();
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("bookingId")
    @JoinColumn(name = "booking_id")
	private BookingEntity booking;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @MapsId("seatId")
    @JoinColumn(name = "seat_id")
	private SeatEntity seat;
	
	@Column(name = "booking_time")
	private String bookingTime;

	public BookingDetailsKey getId() {
		return id;
	}

	public void setId(BookingDetailsKey id) {
		this.id = id;
	}

	public BookingEntity getBooking() {
		return booking;
	}

	public void setBooking(BookingEntity booking) {
		this.booking = booking;
	}

	public SeatEntity getSeat() {
		return seat;
	}

	public void setSeat(SeatEntity seat) {
		this.seat = seat;
	}

	public String getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}

}
