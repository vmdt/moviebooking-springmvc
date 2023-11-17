package com.bookmovie.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "movie_type")
public class MovieTypeEntity extends BaseEntity {
	@Column(name = "type_name")
	private String typeName;
	
	@OneToMany(mappedBy = "type")
	private List<MovieEntity> movies;

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<MovieEntity> getMovies() {
		return movies;
	}

	public void setMovies(List<MovieEntity> movies) {
		this.movies = movies;
	}
	
	
}
