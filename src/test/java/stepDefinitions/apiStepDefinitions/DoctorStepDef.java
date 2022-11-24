package stepDefinitions.apiStepDefinitions;

import API.base_url.MedunnaBaseUrl;
import API.pojos.doctorpojos.*;
import io.cucumber.java.en.And;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.it.Ma;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ObjectMapperUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class DoctorStepDef extends MedunnaBaseUrl {

    Response response;

    @Given("Url {string}")
    public void url(String url) {

        response = given().contentType(ContentType.JSON).headers("Authorization", "Bearer " + generateToken()).when().get(url);
        response.prettyPrint();
    }

    @Then("User sends Get Request")
    public void userSendsGetRequest() {
    }

    @Then("Status code {int}")
    public void statusCode(int statusCode) {

        response.then().statusCode(statusCode);
        assertEquals(statusCode, response.getStatusCode());
    }

    @And("doctor bilgilerini dogrula")
    public void doctorBilgileriniDogrula() {

        CountryInner countryInner = new CountryInner(1201, "Türkiye");
        Cstate cstate = new Cstate(1255, "California", countryInner);
        Country country = new Country(71230, "Gambia");
        User user = new User("anonymousUser",
                "2022-11-16T10:19:40.206848Z",
                302609,
                "doktorteam16",
                "Doktor",
                "Team16",
                "doktorteam16@gmail.com",
                true,
                "en",
                null, null, "123-65-2365");
        Physician expectedData = new Physician("cevik",
                "2022-11-18T16:03:39.976299Z",
                309705,
                "Doktor",
                "Team16",
                "2002-03-11T22:00:00Z",
                "999-343-4343",
                "MALE", "Apositive",
                "Papua Yeni Gine",
                "team16hasta", user,
                "ALLERGY_IMMUNOLOGY",
                null, country, cstate,
                1200.00,
                null, null);
        System.out.println("expectedData = " + expectedData);


        Physician actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), Physician.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.getCreatedBy(), actualData.getCreatedBy());
        assertEquals(expectedData.getId(), actualData.getId());
        assertEquals(expectedData.getUser().getEmail(), actualData.getUser().getEmail());
        assertEquals(expectedData.getCountry().getName(), actualData.getCountry().getName());
        assertEquals(expectedData.getCstate().getId(), actualData.getCstate().getId());
        assertEquals(expectedData.getCstate().getCountry().getId(), actualData.getCstate().getCountry().getId());

    }
}
