package np.com.prahladpanthi.movieinfoservice.controller;

import np.com.prahladpanthi.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieInfoController {

    @GetMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
        Movie movie = null;
        switch (movieId) {
            case "HP":
                movie = new Movie(movieId, "Harry Potter");
                break;
            case "FF":
                movie = new Movie(movieId, "Fast and Furious");
                break;
            case "TH":
                movie = new Movie(movieId, "The Hunt");
                break;
            case "TM":
                movie = new Movie(movieId, "The Mist");
                break;
            case "S30":
                movie = new Movie(movieId, "Super 30");
                break;
            default:
                movie = new Movie(movieId, "Demo Movie " + movieId);
                break;
        }
        return movie;
    }
}
