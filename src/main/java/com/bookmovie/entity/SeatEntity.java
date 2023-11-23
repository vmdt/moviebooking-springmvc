package com.bookmovie.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "seat")
public class SeatEntity extends BaseEntity {
	
	@Column(name = "seat_code")
	private String seatCode;
	
	@Column(name = "price")
	private int price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "movie_id")
	private MovieEntity movie;
	
	@OneToMany(mappedBy = "seat", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<BookingDetailsEntity> bookingDetails;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "show_timing_id")
	private ShowTimingEntity showTiming;

	@Column(name = "status")
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSeatCode() {
		return seatCode;
	}

	public void setSeatCode(String seatCode) {
		this.seatCode = seatCode;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public MovieEntity getMovie() {
		return movie;
	}

	public void setMovie(MovieEntity movie) {
		this.movie = movie;
	}

	public List<BookingDetailsEntity> getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(List<BookingDetailsEntity> bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

	public ShowTimingEntity getShowTiming() {
		return showTiming;
	}

	public void setShowTiming(ShowTimingEntity showTiming) {
		this.showTiming = showTiming;
	}
	
}
