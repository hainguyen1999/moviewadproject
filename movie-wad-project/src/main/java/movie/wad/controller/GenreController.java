package movie.wad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import movie.wad.model.Genre;
import movie.wad.service.GenreService;

@Controller
public class GenreController {
	@Autowired
	private GenreService genreService;
	
	@GetMapping("/genre")
	public String getGenres(Model model) {
		
		List<Genre> genreList = genreService.getGenres();
		
		model.addAttribute("genres", genreList);
		
		return "index";
	}
}
