package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.MedunnaPageS;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class MedunnaStepDefUs14 {

    MedunnaPageS page = new MedunnaPageS();

    @When("doktor olarak login olur")
    public void doktorOlarakLoginOlur() {
        page.accountMenu.click();
        page.signIn.click();
        page.usernameBox.sendKeys(ConfigReader.getProperty("physicianUsername"));
        page.passwordBox.sendKeys(ConfigReader.getProperty("physicianPassword"));
        page.signInButton.click();
    }

    @Then("doktor Mypages menusunden MyInpatient'e tiklar")
    public void doktorMypagesMenusundenMyInpatientETiklar() {


        page.myPages.click();
        ReusableMethods.waitFor(3);
        page.myInpatients.click();
        ReusableMethods.waitFor(3);
    }

    @And("Doctor ID, start and end dates, description, created date appointment id, status, room and patient bilgilerini gorunur oldugunu dogrular")
    public void doctorIDStartAndEndDatesDescriptionCreatedDateAppointmentIdStatusRoomAndPatientBilgileriniGorunurOldugunuDogrular() throws IOException {

        // List<WebElement> expected = page.patientTableTitles;

        for (WebElement w : page.patientTableTitles) {  // direkt page sayfasindan list'i aldik
            assertTrue(w.isDisplayed());
        }
        ReusableMethods.getScreenshotWebElement("PatientTable", page.patientTable);
    }

    @Then("doctor bilgilerini guncellemek istedigi hastaya edit yapar")
    public void doctorBilgileriniGuncellemekIstedigiHastayaEditYapar() {

        ReusableMethods.waitForClickable(page.editButton,20);
        ReusableMethods.waitForVisibility(page.editButton,15);
        int editButton = ReusableMethods.random().nextInt(page.editButtons.size() - 1);
        ReusableMethods.jsScrollClick(page.editButtons.get(editButton));

    }

    @Then("doctor status bilgisi secer ve Save button'a tiklar")
    public void doctorStatusBilgisiSecerVeSaveButtonATiklar() throws IOException {

        ReusableMethods.getActions()
                .click(page.statusDdm)
                .sendKeys(Keys.ENTER)
                .perform();
        ReusableMethods.getScreenshot("status");
        ReusableMethods.jsScroll(page.statusDdm);
        List<WebElement> statusDdm = ReusableMethods.select(page.statusDdm).getOptions();
        int index = ReusableMethods.random().nextInt(statusDdm.size() - 1);
        ReusableMethods.select(page.statusDdm).selectByIndex(index);


        ReusableMethods.waitForVisibility(page.saveButtonCreatePatient, 15);
        ReusableMethods.jsScrollClick(page.saveButtonCreatePatient);
        ReusableMethods.getScreenshot("statusSecimSave");
        ReusableMethods.waitFor(2);

    }
}
