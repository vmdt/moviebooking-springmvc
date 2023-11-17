package com.bookmovie.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "show_timing")
public class ShowTimingEntity extends BaseEntity {
	@Column(name = "time")
	private String time;
	
	@OneToMany(mappedBy = "showTiming")
	private List<SeatEntity> seats;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<SeatEntity> getSeats() {
		return seats;
	}

	public void setSeats(List<SeatEntity> seats) {
		this.seats = seats;
	}
	
	
}
