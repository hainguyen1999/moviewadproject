package movie.wad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import movie.wad.model.Actor;

import movie.wad.service.ActorService;

@Controller
public class ActorController {
	@Autowired
	private ActorService actorService;
	
	@GetMapping("/actors")
	public String getActors(Model model) {
		
		List<Actor> actorList = actorService.getActors();
		
		model.addAttribute("actors", actorList);
		
		return "actor";
	}
}
