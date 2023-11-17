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
@Table(name = "movie")
public class MovieEntity extends BaseEntity {
	
	@Column(name = "movie_name")
	private String movieName;
	
	@Column(name = "thumbnail")
	private String thumbnail;
	
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;
	
	@Column(name = "duration")
	private int duration;
	
	@Column(name = "language")
	private String language;
	
	@Column(name = "directors", columnDefinition = "TEXT")
	private String directors;
	
	@Column(name = "actors", columnDefinition = "TEXT")
	private String actors;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_id")
	private MovieTypeEntity type;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nation_id")
	private NationEntity nation;
	
	@OneToMany(mappedBy = "movie", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<FeedbackEntity> feedbacks;
	
	@OneToMany(mappedBy = "movie", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<SeatEntity> seats;
	
	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDirectors() {
		return directors;
	}

	public void setDirectors(String directors) {
		this.directors = directors;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public MovieTypeEntity getType() {
		return type;
	}

	public void setType(MovieTypeEntity type) {
		this.type = type;
	}

	public NationEntity getNation() {
		return nation;
	}

	public void setNation(NationEntity nation) {
		this.nation = nation;
	}

	public List<FeedbackEntity> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<FeedbackEntity> feedbacks) {
		this.feedbacks = feedbacks;
	}
	
}
