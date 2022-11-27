package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.*;
import org.apache.poi.ss.usermodel.*;
import pages.MedunnaPageS2;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.*;

import static org.junit.Assert.*;

public class MedunnaStepDefUs08 {

    MedunnaPageS2 page = new MedunnaPageS2();
    String gecerliSifre;
    String eskiSifre;
    String bos;
    String filePath;
    FileInputStream fis;
    Workbook workbook;
    FileOutputStream fos;
    Row row;
    Cell cell;
    Sheet sheet;

    @Given("S2 kullanici {string} url'e gider")
    public void S2kullaniciUrlEGider(String url) {

        Driver.getDriver().get(ConfigReader.getProperty(url));
    }

    @When("S2 kullanici login olur")
    public void S2kullaniciLoginOlur() {

        page.accountMenu.click();
        page.signIn.click();
        page.usernameBox.sendKeys(ConfigReader.getProperty("userUsername"));
        page.passwordBox.sendKeys(ConfigReader.getProperty("userPassword"));
        page.signInButton.click();

        // Actions Yontem
        //ReusableMethods.getActions()
        //        .click(page.usernameBox)
        //        .sendKeys(ConfigReader.getProperty("userUsername"))
        //        .sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("userPassword"))
        //        .sendKeys(Keys.ENTER).perform();
    }

    @Then("S2 kullanici account menuden password link tiklar")
    public void S2kullaniciAccountMenudenPasswordLinkTiklar() {

        page.accountMenu.click();
        page.passwordLink.click();
    }

    @And("S2 kullanici current password girer")
    public void S2kullaniciCurrentPasswordGirer() {

        page.currentPasswordBox.sendKeys(ConfigReader.getProperty("userPassword"));
    }

    @And("S2 kullanici new password girer")
    public void S2kullaniciNewPasswordGirer() {

        page.newPasswordBox.sendKeys(ConfigReader.getProperty("userPassword"));
    }

    @And("S2 kullanici new password confirmation girer")
    public void S2kullaniciNewPasswordConfirmationGirer() {

        page.confirmPasswordBox.sendKeys(ConfigReader.getProperty("userPassword"));
    }

    @And("S2 kullanici {string} mesajinin gorunur olmadigini dogrular")
    public void S2kullaniciMesajininGorunurOlmadiginiDogrular(String message) throws IOException {


        try {
            assertFalse(page.notMatchTextMessage.isDisplayed());
        } catch (Exception e) {
            ReusableMethods.waitFor(2);
            ReusableMethods.getScreenshotWebElement("SSpasword", page.passwordScreen);
        }

    }

    @And("S2 sayfayi kapatir")
    public void S2sayfayiKapatir() {

        Driver.closeDriver();
    }

    @And("S2 kullanici Password strenght seviyesinin limegreen oldugunu dogrular")
    public void S2kullaniciPasswordStrenghtSeviyesininLimegreenOldugunuDogrular() throws IOException {

        assertEquals(4, page.limeGreenStrength.size());
        ReusableMethods.getScreenshotWebElement("limegreenSS", page.strengthBar);
    }

    @And("S2 kullanici Password strength seviyesinin green oldugunu dogrular")
    public void S2kullaniciPasswordStrengthSeviyesininGreenOldugunuDogrular() throws IOException {

        assertEquals(5, page.greenStrength.size());
        ReusableMethods.getScreenshotWebElement("SSgreen", page.strengthBar);
    }

    @And("S2 kullanici kucuk harf,buyuk harf,rakam ve ozel karakter sartlarindan herhangi ucu ile{string} girer")
    public void S2kullaniciKucukHarfBuyukHarfRakamVeOzelKarakterSartlarindanHerhangiUcuIleGirer(String password) {

        page.newPasswordBox.sendKeys(password);
    }

    @And("S2 kullanici {string} girmedigi sifre sartini ekler")
    public void S2kullaniciGirmedigiSifreSartiniEkler(String karakter) {

        page.newPasswordBox.sendKeys(karakter);
    }
    @And("S2 kullanici {int} saniye bekler")
    public void S2kullaniciSaniyeBekler(int sn) {

        ReusableMethods.waitFor(sn);
    }

    @And("S2 kullanici kucuk harf,buyuk harf,rakam ve ozel karakter ile en az yedi karakterli new password girer")
    public void S2kullaniciKucukHarfBuyukHarfRakamVeOzelKarakterIleEnAzYediKarakterliNewPasswordGirer() {

        page.newPasswordBox.sendKeys("javA011!!");
    }

    @And("S2 kullanici save butonuna tiklar")
    public void S2kullaniciSaveButonunaTiklar() {


        page.saveButton.click();
    }

    @And("S2 kullanici Password changed! uyarisinin gorunur olmadigini dogrular")
    public void S2kullaniciPasswordChangedUyarisininGorunurOlmadiginiDogrular() {

        try {

            ReusableMethods.waitForVisibility(page.passwordChangedMessage, 15);
            assertTrue(page.passwordChangedMessage.isDisplayed());
            ReusableMethods.getScreenshot("eskisifrekullanildi");

        } catch (Exception e) {

            System.out.println("Eski sifre kullanilabildi");
            try {
                ReusableMethods.getScreenshot("EskiSifreKullanildi");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }


    @And("S2 kullanici new password box'a sifre girer")
    public void S2kullaniciNewPasswordBoxASifreGirer() {

        page.newPasswordBox.sendKeys("qwwertA!w");
    }

    @And("S2 kullanici new password confirmation box'a new passworddan farkli sifre girer")
    public void S2kullaniciNewPasswordConfirmationBoxANewPassworddanFarkliSifreGirer() {

        page.confirmPasswordBox.sendKeys("qwrwett!A");
        page.saveButton.click();
    }

    @And("S2 kullanici {string} mesajinin gorunur oldugunu dogrular")
    public void S2kullaniciMesajininGorunurOldugunuDogrular(String message) throws IOException {

        assertTrue(page.notMatchTextMessage.isDisplayed());
        ReusableMethods.getScreenshotWebElement("dontMatch", page.notMatchTextMessage);
    }

    @And("S2 kullanici kucuk harf,buyuk harf,rakam ve ozel karakter ile en fazla alti karakterli new password girer")
    public void S2kullaniciKucukHarfBuyukHarfRakamVeOzelKarakterIleEnFazlaAltiKarakterliNewPasswordGirer() {

        page.newPasswordBox.sendKeys("A23!aa");
    }

    @And("S2 kullanici Password strength seviyesinin red oldugunu dogrular")
    public void S2kullaniciPasswordStrengthSeviyesininRedOldugunuDogrular() throws IOException {

        assertEquals(1, page.redStrength.size());
        ReusableMethods.getScreenshotWebElement("redStrength", page.strengthBar);
    }


    @And("S2 Kullanici {string} boxa en az yedi karakter girerek strenght bar'in farkli durumlarini test eder.")
    public void S2kullaniciBoxaEnAzYediKarakterGirerekStrenghtBarInFarkliDurumlariniTestEder(String password) throws IOException {

        page.newPasswordBox.sendKeys(password);
        ReusableMethods.getScreenshotWebElement(password, page.strength);
    }


    @When("S2 kullanici login olup account menuden password linke tiklar")
    public void S2kullaniciLoginOlupAccountMenudenPasswordLinkeTiklar() throws IOException {


        filePath = "src/resources/excelTest.xlsx";
        fis = new FileInputStream(filePath);
        workbook = WorkbookFactory.create(fis);
        // read
        //System.out.println(wb.getSheet("Sayfa1").getRow(0).getCell(0));
        //System.out.println(wb.getSheet("Sayfa1").getRow(1).getCell(0));

        gecerliSifre = workbook.getSheet("Sayfa1").getRow(0).getCell(0).toString();
        eskiSifre = workbook.getSheet("Sayfa1").getRow(1).getCell(0).toString();
        bos = "";

        // login
        page.accountMenu.click();
        ReusableMethods.waitFor(2);
        page.signIn.click();
        ReusableMethods.waitFor(2);
        page.usernameBox.sendKeys(ConfigReader.getProperty("excelUsername"));
        ReusableMethods.waitFor(2);
        page.passwordBox.sendKeys(gecerliSifre);
        ReusableMethods.waitFor(2);
        page.signInButton.click();
        page.accountMenu.click();
        ReusableMethods.waitFor(2);
        page.passwordLink.click();
        ReusableMethods.waitFor(2);
    }

    @Then("S2 kullanici current passwordu girer ve new password ve confirm password'e eski sifreyi girer")
    public void S2kullaniciCurrentPassworduGirerVeNewPasswordVeConfirmPasswordEEskiSifreyiGirer() throws IOException {

        filePath = "src/resources/excelTest.xlsx";

        page.currentPasswordBox.sendKeys(gecerliSifre);
        ReusableMethods.waitFor(2);
        page.newPasswordBox.sendKeys(eskiSifre);
        ReusableMethods.waitFor(2);
        page.confirmPasswordBox.sendKeys(eskiSifre);
        ReusableMethods.waitFor(2);

        bos = gecerliSifre;
        gecerliSifre = eskiSifre;
        eskiSifre = bos;

        System.out.println("sifre = " + gecerliSifre);
        System.out.println("eskiSifre = " + eskiSifre);


        // Delete
        sheet = workbook.getSheet("Sayfa1");
        row = sheet.getRow(0);
        cell = row.getCell(0);
        row.removeCell(cell);
        fos = new FileOutputStream(filePath);
        workbook.write(fos);
        // Delete
        sheet = workbook.getSheet("Sayfa1");
        row = sheet.getRow(1);
        cell = row.getCell(0);
        row.removeCell(cell);
        fos = new FileOutputStream(filePath);
        workbook.write(fos);


        //write
        workbook.getSheet("Sayfa1").getRow(0).createCell(0).setCellValue(gecerliSifre);
        workbook.getSheet("Sayfa1").getRow(1).createCell(0).setCellValue(eskiSifre);
        fos = new FileOutputStream(filePath);
        workbook.write(fos);

        fos.close();
        fis.close();
        workbook.close();
    }
}
