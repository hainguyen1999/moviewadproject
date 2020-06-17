package movie.wad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movie.wad.model.Genre;
import movie.wad.repository.GenreRepository;

@Service
public class GenreService {
	
	@Autowired
	private GenreRepository genreRepository;
	
	public List<Genre> getGenres(){
		return genreRepository.findAll();
	}
}
