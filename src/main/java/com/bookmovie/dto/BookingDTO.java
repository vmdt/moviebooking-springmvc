package com.bookmovie.dto;

import java.util.List;

public class BookingDTO {
	private Long id;
	private Long userId;
	private int totalPrice;
	private String status;
	private List<Long> seatIds;
	
	
	
	public List<Long> getSeatIds() {
		return seatIds;
	}
	public void setSeatIds(List<Long> seatIds) {
		this.seatIds = seatIds;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
