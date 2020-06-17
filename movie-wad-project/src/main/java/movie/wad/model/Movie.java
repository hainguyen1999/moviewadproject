package movie.wad.model;

import java.io.Serializable;
import java.time.Year;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "movie")

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class)
public class Movie implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;
	@Column(name = "year")
	private int year;
	@Column(name = "rating")
	private Double rating;
	
	@ManyToMany
	@JoinTable(
			name = "movie_actor",
			joinColumns = {@JoinColumn(name = "movieid")},
			inverseJoinColumns = {@JoinColumn(name = "actorid")}
			)
	private List<Actor> actors;
	
	@ManyToOne
	@JoinColumn(name="directorid", insertable=false, updatable=false)
	private Director director;
	
	@ManyToMany
	@JoinTable(
			name = "movie_genre",
			joinColumns = {@JoinColumn(name = "movieid")},
			inverseJoinColumns = {@JoinColumn(name = "genreid")}
			)
	private List<Genre> genres;
	
	@Column(name="image")
	private String image;
	
	public Movie() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	public Movie(Long id, String title, String description, int year, Double rating, List<Actor> actors,
			Director director, List<Genre> genres, String image) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.year = year;
		this.rating = rating;
		this.actors = actors;
		this.director = director;
		this.genres = genres;
		this.image = image;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", description=" + description + ", year=" + year + ", rating="
				+ rating + ", actors=" + actors + ", director=" + director + ", genres=" + genres + "]";
	}

	
	

	
}