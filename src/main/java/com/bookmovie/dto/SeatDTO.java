package com.bookmovie.dto;

public class SeatDTO {
	private Long id;
	private String seatCode;
	private Long movieId;
	private Long showTimingId;
	private int price;
	private String status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSeatCode() {
		return seatCode;
	}
	public void setSeatCode(String seatCode) {
		this.seatCode = seatCode;
	}
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public Long getShowTimingId() {
		return showTimingId;
	}
	public void setShowTimingId(Long showTimingId) {
		this.showTimingId = showTimingId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
