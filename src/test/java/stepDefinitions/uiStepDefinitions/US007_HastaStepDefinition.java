package stepDefinitions.uiStepDefinitions;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.medunnaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Map;


public class US007_HastaStepDefinition {

    medunnaPage medunna = new medunnaPage();

    @Given("Hasta Medunna Ana sayfasına gider")
    public void hastaMedunnaAnaSayfasınaGider() {

        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }

    @When("Hasta Make an Appointment butonunu basar")

    public void hastaMakeAnAppointmentButonunuBasar() {

        medunna.Appointment.click();
    }

    @And("Hasta randevu bilgilerini girer")
    public void hastaRandevuBilgileriniGirer(DataTable dataTable) {

        List<Map<String, String>> kayitBilgileri = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> e : kayitBilgileri) {

            for (Map.Entry<String, String> entry : e.entrySet()) {

                ReusableMethods.enterField(entry.getKey(), entry.getValue());
            }
            ReusableMethods.waitFor(3);
        }
    }
}
