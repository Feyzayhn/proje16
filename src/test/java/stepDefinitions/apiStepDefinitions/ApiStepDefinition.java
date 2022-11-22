package stepDefinitions.apiStepDefinitions;

import API.base_url.MedunnaBaseUrl;
import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ApiStepDefinition extends MedunnaBaseUrl {
    Response response;

    //https://medunna.com/api/physicians/322880

    @Given("doctor bilgilerini goruntuler")
    public void doctorBilgileriniGoruntuler() {

        System.out.println(generateToken());

        //spec.pathParams("1", "physicians", "2", 322880);
        //response = given().spec(spec).contentType(ContentType.JSON).headers("Authorization", "Bearer " + generateToken()).when().get("/{1}/{2}");


        String url = "https://www.medunna.com/api/physicians/322880";
        response = given().contentType(ContentType.JSON).headers("Authorization", "Bearer " + generateToken()).when().get(url);
        response.prettyPrint();
    }
}
