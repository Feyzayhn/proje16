package API.pojos.doctorpojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

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

    public CountryInner(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CountryInner() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
