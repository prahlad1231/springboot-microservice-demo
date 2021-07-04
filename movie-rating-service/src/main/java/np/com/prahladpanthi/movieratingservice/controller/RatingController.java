package np.com.prahladpanthi.movieratingservice.controller;

import np.com.prahladpanthi.movieratingservice.models.Rating;
import np.com.prahladpanthi.movieratingservice.models.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 4);
    }

    @GetMapping("users/{userId}")
    public UserRating getRatingOfUser(@PathVariable("userId") String userId) {
        List<Rating> userRating = null;
        if (userId.equals("12")) {
            userRating = Arrays.asList(
                    new Rating("HP", 4),
                    new Rating("FF", 3),
                    new Rating("TH", 2)
            );
        } else if (userId.equals("99")) {
            userRating = Arrays.asList(
                    new Rating("PP", 3)
            );
        } else {
            userRating = Arrays.asList(
                    new Rating("TM", 3),
                    new Rating("S30", 5)
            );
        }
        return new UserRating(userRating);
    }
}
