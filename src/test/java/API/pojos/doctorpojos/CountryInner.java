package API.pojos.doctorpojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryInner {
    /*
   "country": {
            "id": 1201,
            "name": "Türkiye"
        }
     */

    private int id;
    private String name;
}
