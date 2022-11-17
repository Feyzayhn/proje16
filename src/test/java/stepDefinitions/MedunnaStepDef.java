package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.MedunnaPageS;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class MedunnaStepDef {

    MedunnaPageS page = new MedunnaPageS();

    @Given("kullanici {string} url'e gider")
    public void kullaniciUrlEGider(String url) {

        Driver.getDriver().get(ConfigReader.getProperty(url));
    }

    @When("kullanici login olur")
    public void kullaniciLoginOlur() {

        page.accountMenu.click();
        page.signIn.click();
        page.usernameBox.sendKeys(ConfigReader.getProperty("patientUsername"));
        page.passwordBox.sendKeys(ConfigReader.getProperty("patientPassword"));
        page.signInButton.click();

        // Actions Yontem
        //ReusableMethods.getActions()
        //        .click(page.usernameBox)
        //        .sendKeys(ConfigReader.getProperty("userUsername"))
        //        .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("userPassword"))
        //        .sendKeys(Keys.ENTER).perform();
    }

    @Then("kullanici account menuden password link tiklar")
    public void kullaniciAccountMenudenPasswordLinkTiklar() {

        page.accountMenu.click();
        page.passwordLink.click();
    }

    @And("kullanici current password girer")
    public void kullaniciCurrentPasswordGirer() {

        page.currentPasswordBox.sendKeys(ConfigReader.getProperty("patientPassword"));
    }

    @And("kullanici new password girer")
    public void kullaniciNewPasswordGirer() {

        page.newPasswordBox.sendKeys(ConfigReader.getProperty("patientPassword"));
    }

    @And("kullanici new password confirmation girer")
    public void kullaniciNewPasswordConfirmationGirer() {

        page.confirmPasswordBox.sendKeys(ConfigReader.getProperty("patientPassword"));
    }

    @And("kullanici {string} mesajinin gorunur olmadigini dogrular")
    public void kullaniciMesajininGorunurOlmadiginiDogrular(String message) throws IOException {

        try {
            Assert.assertFalse(page.notMatchTextMessage.isDisplayed());
        } catch (Exception e) {
            ReusableMethods.waitFor(2);
            ReusableMethods.getScreenshotWebElement("SSpasword", page.passwordScreen);
        }
    }

    @And("sayfayi kapatir")
    public void sayfayiKapatir() {

        Driver.quitDriver();
    }


    @And("kullanici Password strenght seviyesinin limegreen oldugunu dogrular")
    public void kullaniciPasswordStrenghtSeviyesininLimegreenOldugunuDogrular() throws IOException {

        Assert.assertEquals(4,page.limeGreenStrength.size());
        ReusableMethods.getScreenshotWebElement("limegreenSS",page.strengthBar);
    }

    @And("kullanici New password'a kucuk harf ekler")
    public void kullaniciNewPasswordAKucukHarfEkler() {

        page.newPasswordBox.sendKeys("aa");
    }

    @And("kullanici Password strength seviyesinin green oldugunu dogrular")
    public void kullaniciPasswordStrengthSeviyesininGreenOldugunuDogrular() throws IOException {

        Assert.assertEquals(5,page.greenStrength.size());
        ReusableMethods.getScreenshotWebElement("SSgreen",page.strengthBar);
    }

    @And("kullanici buyuk harf,rakam ve ozel karakter ile en az yedi karakter new password girer")
    public void kullaniciBuyukHarfRakamVeOzelKarakterIleEnAzYediKarakterNewPasswordGirer() {

        page.newPasswordBox.sendKeys("AS1222!!");
    }

    @And("kullanici kucuk harf,rakam ve ozel karakter ile en az yedi karakter new password girer")
    public void kullaniciKucukHarfRakamVeOzelKarakterIleEnAzYediKarakterNewPasswordGirer() {

        page.newPasswordBox.sendKeys("aaa123232!!");
    }

    @And("kullanici New password'a buyuk harf ekler")
    public void kullaniciNewPasswordABuyukHarfEkler() {

        page.newPasswordBox.sendKeys("BB");
    }

    @And("kullanici {int} bekler")
    public void kullaniciBekler(int saniye) {

        ReusableMethods.waitFor(saniye);
    }

    @And("kullanici kucuk harf,rakam ve ozel karakter ile en az yedi karakter {string} girer")
    public void kullaniciKucukHarfRakamVeOzelKarakterIleEnAzYediKarakterGirer(String password) {

        page.newPasswordBox.sendKeys(password);
    }

    @And("kullanici {string} buyuk harf ekler")
    public void kullaniciBuyukHarfEkler(String karakter) {

        page.newPasswordBox.sendKeys(karakter);
    }
}
