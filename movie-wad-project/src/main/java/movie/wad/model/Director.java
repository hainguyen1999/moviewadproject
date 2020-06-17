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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "director")

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Director {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long id;
	@Column(name = "name")
	public String name;
	@Column(name = "dob")
	public Date dob;
	@Column(name = "bio")
	public String bio;
	
	@OneToMany(mappedBy = "director", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Movie> movies;
	
	public Director() {}
	
	public Long getId() {
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

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovie(List<Movie> movies) {
		this.movies = movies;
	}


	public Director(Long id, String name, Date dob, String bio, List<Movie> movies) {
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.bio = bio;
		this.movies = movies;
	}
	

	

}
