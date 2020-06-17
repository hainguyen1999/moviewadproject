package movie.wad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movie.wad.model.Director;
import movie.wad.repository.DirectorRepository;

@Service
public class DirectorService {
	
	@Autowired
	private DirectorRepository directorRepository;
	
	
	public List<Director> getDirectors(){
		return directorRepository.findAll();
	}
}
