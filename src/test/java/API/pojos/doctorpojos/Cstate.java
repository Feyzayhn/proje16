package API.pojos.doctorpojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cstate {

    /*
    "cstate": {
        "id": 1255,
        "name": "California",
        "country": {
            "id": 1201,
            "name": "Türkiye"
        }
    },
     */

    private int id;
    private String name;
    private CountryInner country;

    public Cstate(int id, String name, CountryInner country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Cstate() {
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

    public CountryInner getCountry() {
        return country;
    }

    public void setCountry(CountryInner country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Cstate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
