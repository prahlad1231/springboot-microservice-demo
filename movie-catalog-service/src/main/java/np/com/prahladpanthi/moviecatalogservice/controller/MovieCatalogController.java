package np.com.prahladpanthi.moviecatalogservice.controller;

import np.com.prahladpanthi.moviecatalogservice.models.CatalogItem;
import np.com.prahladpanthi.moviecatalogservice.models.Movie;
import np.com.prahladpanthi.moviecatalogservice.models.Rating;
import np.com.prahladpanthi.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
        // get all rated movie IDs
        UserRating ratings = restTemplate
                .getForObject("http://localhost:8083/ratings/users/" + userId, UserRating.class ); // user ParameterizedTypeReference<Wrapper<>> for other types

        // for each movie ID, call movie info service and get details
        return ratings.getUserRating().stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), "Awesome movie", rating.getRating());
        }).collect(Collectors.toList());

        // using reactive web - asynchronous
        /*return ratings.stream().map(rating -> {
            Movie movie = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/movies/" + rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block(); // blocking until mono gets the data in its container
            return new CatalogItem(movie.getName(), "Awesome", rating.getRating());
        }).collect(Collectors.toList());*/
    }
}
