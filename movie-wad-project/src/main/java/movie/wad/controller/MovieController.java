package movie.wad.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import movie.wad.model.Movie;
import movie.wad.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping("/")
	public String getMovies(Model model, String keyword) {
		
		List<Movie> movieList = movieService.getAllMovies();
		
		if(keyword != null) {
			model.addAttribute("movies", movieService.findByKeyword(keyword));
		}
		else {
			model.addAttribute("movies", movieList);
		}
			return "index";
		}
	
	
	@GetMapping("/movie")
	public String loadAbout(Model model, ModelMap map) {
		
		return "film_sample";
	}
	
	@RequestMapping("/movie/findById")
	@ResponseBody
	public Optional<Movie> findById(Long id) {
		return movieService.findById(id);
	}
	

}
