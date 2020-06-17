package movie.wad.model;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "actor")

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Actor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "dob")
	private Date dob;
	@Column(name = "bio")
	private String bio;
	
	@ManyToMany(mappedBy = "actors", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Movie> movies;
	
	public Actor() {}
	
	public long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getBio() {
		return bio;
	}


	public void setBio(String bio) {
		this.bio = bio;
	}

	
	public Set<Movie> getMovies() {
		return movies;
	}


	public void setMovie(Set<Movie> movies) {
		this.movies = movies;
	}

	
	
	public Actor(Long id, String name, Date dob, String bio, Set<Movie> movies) {
		
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.bio = bio;
		this.movies = movies;
	}



	
	
}