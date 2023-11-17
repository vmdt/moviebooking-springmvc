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
@Table(name = "booking")
public class BookingEntity extends BaseEntity {
	
	@Column(name = "total_price")
	private int totalPrice;
	
	@Column(name = "status")
	private String status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@OneToMany(mappedBy = "booking", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<BookingDetailsEntity> bookingDetails;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public List<BookingDetailsEntity> getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(List<BookingDetailsEntity> bookingDetails) {
		this.bookingDetails = bookingDetails;
	}
	
	
}
