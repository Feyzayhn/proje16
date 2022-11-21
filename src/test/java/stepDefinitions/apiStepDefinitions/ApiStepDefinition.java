package stepDefinitions.apiStepDefinitions;


import API.base_url.MedunnaBaseUrl;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiStepDefinition extends MedunnaBaseUrl {
    Response response;

    //https://medunna.com/api/physicians/304902
    @Given("doctor bilgilerini goruntuler")
    public void doctorBilgileriniGoruntuler() {

        //spec.pathParams("1", "physicians", "2", "147333");
        //response = given().headers("Authorization", "Bearer " + generateToken(), "Accept", ContentType.JSON).spec(spec).when().get("/{1}/{2}");

        String url = "https://www.medunna.com/api/physicians/147333";
        response = given().contentType(ContentType.JSON).headers("Authorization", "Bearer " + generateToken()).when().get(url);
        response.prettyPrint();
    }
}
