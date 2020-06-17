package movie.wad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import movie.wad.model.Actor;
import movie.wad.repository.ActorRepository;

@Service
public class ActorService {
	
	@Autowired
	private ActorRepository actorRepository;
	
	public List<Actor> getActors(){
		return actorRepository.findAll();
	}
}
