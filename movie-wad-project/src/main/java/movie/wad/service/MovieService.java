package movie.wad.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movie.wad.model.Movie;
import movie.wad.repository.MovieRepository;

@Service
public class MovieService{
	
	@Autowired
	private MovieRepository movieRepository;
	
	//return list of movies
	public List<Movie> getAllMovies(){
		return movieRepository.findAll();
	}
	
	//Get movie title by keyword
	public List<Movie> findByKeyword(String keyword){
		return movieRepository.findByKeyword(keyword);
	}
	
	//Get by id
	public Optional<Movie> findById(Long id) {
		return movieRepository.findById(id);
	}
	
}
