package API.pojos.doctorpojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    /*
    "user": {
        "createdBy": "anonymousUser",
        "createdDate": "2022-11-16T10:19:40.206848Z",
        "id": 302609,
        "login": "doktorteam16",
        "firstName": "Doktor",
        "lastName": "Team16",
        "email": "doktorteam16@gmail.com",
        "activated": true,
        "langKey": "en",
        "imageUrl": null,
        "resetDate": null,
        "ssn": "123-65-2365"
    },
     */
    private String createdBy;
    private String createdDate;
    private int id;
    private String login;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean activated;
    private String langKey;
    private Object imageUrl;
    private Object resetDate;
    private String ssn;

}
