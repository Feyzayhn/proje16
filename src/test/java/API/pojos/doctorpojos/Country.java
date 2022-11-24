package API.pojos.doctorpojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {

    /*
    "country": {
        "id": 71230,
        "name": "Gambia"
    },
     */
    private int id;
    private String name;

}
