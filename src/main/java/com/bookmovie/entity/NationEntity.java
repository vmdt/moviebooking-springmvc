package com.bookmovie.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "nation")
public class NationEntity extends BaseEntity {
	@Column(name = "nation_name")
	private String nationName;
	
	@OneToMany(mappedBy = "nation")
	private List<MovieEntity> movies;

	public String getNationName() {
		return nationName;
	}

	public void setNationName(String nationName) {
		this.nationName = nationName;
	}

	public List<MovieEntity> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieEntity> movies) {
		this.movies = movies;
	}
	
	
}
