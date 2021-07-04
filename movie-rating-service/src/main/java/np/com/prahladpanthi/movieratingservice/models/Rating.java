package np.com.prahladpanthi.movieratingservice.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Rating {
    private String movieId;

    private Integer rating;

    public Rating(String movieId, Integer rating) {
        this.movieId = movieId;
        this.rating = rating;
    }
}
