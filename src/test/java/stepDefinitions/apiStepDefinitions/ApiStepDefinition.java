package stepDefinitions.apiStepDefinitions;


import API.base_url.MedunnaBaseUrl;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiStepDefinition extends MedunnaBaseUrl {

    @Given("doctor bilgilerini goruntuler")
    public void doctorBilgileriniGoruntuler() {
        Response response;
        //https://medunna.com/api/physicians/304902
        //spec.pathParams("first", "physicians", "second", "147333");


        response = given().contentType(ContentType.JSON).headers("Authorization", "Bearer " + generateToken()).when().get("https://www.medunna.com/api/physicians/147333");
        //response = given().spec(spec).headers("Authorization", "Bearer " + generateToken()).when().get("/{first}/{second}");
        response.prettyPrint();
    }
}
