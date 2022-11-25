package stepDefinitions.jdbcStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.ConfigReader;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.DataBaseUtility.*;

public class DBdersStepDef {

    List<Object> actualData;

    @Given("user connection kurar")
    public void userConnectionKurar() {

        createConnection2(ConfigReader.getProperty("database_url"),
                ConfigReader.getProperty("database_username"),
                ConfigReader.getProperty("database_password"));


    }

    @And("user tum yeni kayitli bilgileri ceker {string} ve {string}")
    public void userTumYeniKayitliBilgileriCekerVe(String query, String columnName) {

        actualData = getColumnData(query, columnName);
        System.out.println(actualData);
    }

    @Then("user kullanici bilgilerini dogrular")
    public void userKullaniciBilgileriniDogrular() {

        assertTrue("do not match", actualData.contains("456-25-6547"));
    }
}
