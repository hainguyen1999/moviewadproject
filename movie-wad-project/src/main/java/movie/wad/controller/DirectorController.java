package movie.wad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import movie.wad.model.Director;
import movie.wad.service.DirectorService;

@Controller
public class DirectorController {
	@Autowired
	private DirectorService directorService;
	
	@GetMapping("/directors")
	public String getDirectors(Model model) {
		
		List<Director> directorList = directorService.getDirectors();
		
		model.addAttribute("directors", directorList);
		
		return "director";
	}
}
