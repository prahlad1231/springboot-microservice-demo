package np.com.prahladpanthi.moviecatalogservice.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CatalogItem {

    private String name;

    private String description;

    private Integer rating;

    public CatalogItem(String name, String description, Integer rating) {
        this.name = name;
        this.description = description;
        this.rating = rating;
    }
}
