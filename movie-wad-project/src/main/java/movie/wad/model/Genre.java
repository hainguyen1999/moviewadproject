package movie.wad.model;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.sql.Date;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import movie.wad.model.Role;

@Entity(name = "genre")

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "genrename")
	public String genrename;
	
	@ManyToMany(mappedBy = "genres", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Movie> movies;

	public Genre() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGenrename() {
		return genrename;
	}

	public void setGenrename(String genrename) {
		this.genrename = genrename;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovie(List<Movie> movies) {
		this.movies = movies;
	}

	
	public Genre(Long id, String genrename, List<Movie> movies) {
		super();
		this.id = id;
		this.genrename = genrename;
		this.movies = movies;
	}
	
	
	
	



	




	
}