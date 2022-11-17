package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.MedunnaPageS;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class MedunnaStepDef {

    MedunnaPageS page = new MedunnaPageS();

    @Given("Kullanici {string} sayfasina gider")
    public void kullaniciSayfasinaGider(String url) {

        Driver.getDriver().get(ConfigReader.getProperty(url));
    }

    @Then("Kullanici login olur")
    public void kullaniciLoginOlur() {

        page.accountMenu.click();

        page.signIn.click();

        page.usernameBox.sendKeys(ConfigReader.getProperty("userUsername"));

        page.passwordBox.sendKeys(ConfigReader.getProperty("userPassword"));

        page.signInButton.click();
    }

    @And("Sayfayi kapatir")
    public void sayfayiKapatir() {

        Driver.closeDriver();
    }

    @Then("Account menuden password link tiklar")
    public void accountMenudenPasswordLinkTiklar() {

        page.accountMenu.click();
        page.passwordLink.click();
    }

    @And("Gecerli password girer")
    public void gecerliPasswordGirer() {

        page.currentPasswordBox.sendKeys(ConfigReader.getProperty("userPassword"));


    }

    @Then("New password girer")
    public void newPasswordGirer() {

        ReusableMethods.waitFor(1);
        page.newPasswordBox.sendKeys(ConfigReader.getProperty("userPassword"));
    }

    @Then("New password confirmation girer")
    public void newPasswordConfirmationGirer() {

        ReusableMethods.waitFor(1);
        page.confirmPasswordBox.sendKeys(ConfigReader.getProperty("userPassword"));
    }

    @And("Save butonuna tiklar")
    public void saveButonunaTiklar() {

        ReusableMethods.waitFor(1);
        page.saveButton.click();
    }


    @And("{string} mesajinin gorundugunu dogrular")
    public void mesajininGorundugunuDogrular(String kelime) throws IOException {

        ReusableMethods.waitForVisibility(page.passwordChangedMessage, 10);
        ReusableMethods.getScreenshotWebElement("Passwordchanged", page.passwordChangedMessage);
        Assert.assertEquals(kelime, page.passwordChangedMessage.getText());
    }

    @Then("Kullanici buyuk harf,rakam ve ozel karakter ile en az yedi karakter new password girer")
    public void kullaniciBuyukHarfRakamVeOzelKarakterIleEnAzYediKarakterNewPasswordGirer() {

        page.newPasswordBox.sendKeys("AAA123!Q");
    }


    @Then("Password strength seviyesinin gorundugunu dogrular")
    public void passwordStrengthSeviyesininGorundugunuDogrular() throws IOException {

        ReusableMethods.getScreenshotWebElement("limegreen",page.strengthBar);
        Assert.assertEquals(4, page.limeGreenStrength.size());
    }

    @And("New password'a kucuk harf ekler")
    public void newPasswordAKucukHarfEkler() {

        page.newPasswordBox.sendKeys("a");
    }

    @And("Password strength seviyesinin degistigini dogrular")
    public void passwordStrengthSeviyesininDegistiginiDogrular() throws IOException {

        ReusableMethods.getScreenshotWebElement("green", page.strengthBar);
        Assert.assertEquals(5, page.greenStrength.size());
    }
}
