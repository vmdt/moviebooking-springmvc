package com.bookmovie.api;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.bookmovie.dto.MovieDTO;
import com.bookmovie.service.IMovieService;
import com.bookmovie.service.ISeatService;

@RestController
public class MovieAPI {
	@Autowired
	private IMovieService movieService;
	
	@Autowired ISeatService seatService;
	
	@RequestMapping(value = "/api/movies", method = RequestMethod.POST, consumes = {"*/*"})
	public MovieDTO createMovie(@RequestBody MovieDTO movieDTO) {
		MovieDTO movie = movieService.save(movieDTO);
		
		// create seats for movie
		for (Long timeId=(long) 1; timeId<=3; timeId++) {
			seatService.initSeats(movie.getId(), timeId, 4);
		}
		
		return movie;
	}
	
  //@RequestMapping(value = "/api/movies", method = RequestMethod.GET, consumes = {"*/*"})
	//public List<MovieDTO> getMovies() {
		//return movieService.findAll(null);
	//}
	//

	@RequestMapping(value = "/api/movies", method = RequestMethod.PUT, consumes = {"*/*"})
	public MovieDTO updateMovie(@RequestBody MovieDTO movieDTO) {
		return movieService.save(movieDTO);
	}
	
	@RequestMapping(value = "/api/movies/{id}", method = RequestMethod.DELETE)
	public void deleteMovie(@PathVariable("id") Long id) {
		movieService.delete(id);
	}
	
	@RequestMapping(value = "/api/movies/upload", method = RequestMethod.POST, consumes = {"*/*"}, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String uploadImage(@RequestParam("file") CommonsMultipartFile file, HttpSession session) {
		ServletContext context = session.getServletContext();  
		String path = context.getRealPath("/resources/images"); 
		String filename=file.getOriginalFilename();
		 try{  
		        byte barr[]=file.getBytes();  
		          
		        BufferedOutputStream bout=new BufferedOutputStream(  
		                 new FileOutputStream(path+"/"+filename));  
		        bout.write(barr);  
		        bout.flush();  
		        bout.close();
		        return "/resources/images/" + filename;
		        
		 } catch(Exception e) {
			 System.out.println(e);
			 return "error";
		 }
	}
	
	@RequestMapping(value = "/api/movies", method = RequestMethod.GET, consumes = {"*/*"})
	public List<MovieDTO> getMovies(@RequestParam("q") String query) {
		return movieService.searchMovie(query);
	}
}
