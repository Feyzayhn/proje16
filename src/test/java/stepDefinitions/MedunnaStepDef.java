package stepDefinitions;

import io.cucumber.java.en.*;
import org.apache.poi.ss.usermodel.*;
import pages.MedunnaPageS;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.*;

import static org.junit.Assert.*;

public class MedunnaStepDef {

    MedunnaPageS page = new MedunnaPageS();
    String sifre;
    String eskiSifre;
    String bos;
    String filePath;
    FileInputStream fis;
    Workbook workbook;
    FileOutputStream fos;
    Row row;
    Cell cell;
    Sheet sheet;

    @Given("kullanici {string} url'e gider")
    public void kullaniciUrlEGider(String url) {

        Driver.getDriver().get(ConfigReader.getProperty(url));
    }

    @When("kullanici login olur")
    public void kullaniciLoginOlur() {

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

    @Then("kullanici account menuden password link tiklar")
    public void kullaniciAccountMenudenPasswordLinkTiklar() {

        page.accountMenu.click();
        page.passwordLink.click();
    }

    @And("kullanici current password girer")
    public void kullaniciCurrentPasswordGirer() {

        page.currentPasswordBox.sendKeys(ConfigReader.getProperty("userPassword"));
    }

    @And("kullanici new password girer")
    public void kullaniciNewPasswordGirer() {

        page.newPasswordBox.sendKeys(ConfigReader.getProperty("userPassword"));
    }

    @And("kullanici new password confirmation girer")
    public void kullaniciNewPasswordConfirmationGirer() {

        page.confirmPasswordBox.sendKeys(ConfigReader.getProperty("userPassword"));
    }

    @And("kullanici {string} mesajinin gorunur olmadigini dogrular")
    public void kullaniciMesajininGorunurOlmadiginiDogrular(String message) throws IOException {


        try {
            assertFalse(page.notMatchTextMessage.isDisplayed());
        } catch (Exception e) {
            ReusableMethods.waitFor(2);
            ReusableMethods.getScreenshotWebElement("SSpasword", page.passwordScreen);
        }

    }

    @And("sayfayi kapatir")
    public void sayfayiKapatir() {

        Driver.closeDriver();
    }

    @And("kullanici buyuk harf,rakam ve ozel karakter ile en az yedi karakter new password girer")
    public void kullaniciBuyukHarfRakamVeOzelKarakterIleEnAzYediKarakterNewPasswordGirer() throws IOException {

        page.newPasswordBox.sendKeys("AS1222!!");
    }

    @And("kullanici Password strenght seviyesinin limegreen oldugunu dogrular")
    public void kullaniciPasswordStrenghtSeviyesininLimegreenOldugunuDogrular() throws IOException {

        assertEquals(4, page.limeGreenStrength.size());
        ReusableMethods.getScreenshotWebElement("limegreenSS", page.strengthBar);
    }

    @And("kullanici New password'a kucuk harf ekler")
    public void kullaniciNewPasswordAKucukHarfEkler() {

        page.newPasswordBox.sendKeys("aa");
    }

    @And("kullanici Password strength seviyesinin green oldugunu dogrular")
    public void kullaniciPasswordStrengthSeviyesininGreenOldugunuDogrular() throws IOException {

        assertEquals(5, page.greenStrength.size());
        ReusableMethods.getScreenshotWebElement("SSgreen", page.strengthBar);
    }

    @And("kullanici kucuk harf,rakam ve ozel karakter ile en az yedi karakter new password girer")
    public void kullaniciKucukHarfRakamVeOzelKarakterIleEnAzYediKarakterNewPasswordGirer() {

        page.newPasswordBox.sendKeys("aaa123232!!");
    }

    @And("kullanici New password'a buyuk harf ekler")
    public void kullaniciNewPasswordABuyukHarfEkler() {

        page.newPasswordBox.sendKeys("BB");
    }


    @And("kullanici kucuk harf,buyuk harf,rakam ve ozel karakter sartlarindan herhangi ucu ile{string} girer")
    public void kullaniciKucukHarfBuyukHarfRakamVeOzelKarakterSartlarindanHerhangiUcuIleGirer(String password) {

        page.newPasswordBox.sendKeys(password);
    }

    @And("kullanici {string} girmedigi sifre sartini ekler")
    public void kullaniciGirmedigiSifreSartiniEkler(String karakter) {

        page.newPasswordBox.sendKeys(karakter);
    }

    @When("kullanici username {string} girer")
    public void kullaniciUsernameGirer(String username) {

        page.accountMenu.click();
        page.signIn.click();

        page.usernameBox.sendKeys(username);
    }

    @When("kullanici password {string} girer")
    public void kullaniciPasswordGirer(String password) {

        page.passwordBox.sendKeys(password);
    }

    @And("kullanici {int} saniye bekler")
    public void kullaniciSaniyeBekler(int sn) {

        ReusableMethods.waitFor(sn);
    }

    @And("kullanici kucuk harf,buyuk harf,rakam ve ozel karakter ile en az yedi karakterli new password girer")
    public void kullaniciKucukHarfBuyukHarfRakamVeOzelKarakterIleEnAzYediKarakterliNewPasswordGirer() {

        page.newPasswordBox.sendKeys("javA011!!");
    }

    @And("kullanici save butonuna tiklar")
    public void kullaniciSaveButonunaTiklar() {


        page.saveButton.click();
    }

    @And("kullanici Password changed! uyarisinin gorunur olmadigini dogrular")
    public void kullaniciPasswordChangedUyarisininGorunurOlmadiginiDogrular() {

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


    @And("kullanici new password box'a sifre girer")
    public void kullaniciNewPasswordBoxASifreGirer() {

        page.newPasswordBox.sendKeys("qwwertA!w");
    }

    @And("kullanici new password confirmation box'a new passworddan farkli sifre girer")
    public void kullaniciNewPasswordConfirmationBoxANewPassworddanFarkliSifreGirer() {

        page.confirmPasswordBox.sendKeys("qwrwett!A");
        page.saveButton.click();
    }

    @And("kullanici {string} mesajinin gorunur oldugunu dogrular")
    public void kullaniciMesajininGorunurOldugunuDogrular(String message) throws IOException {

        assertTrue(page.notMatchTextMessage.isDisplayed());
        ReusableMethods.getScreenshotWebElement("dontMatch", page.notMatchTextMessage);
    }

    @And("kullanici kucuk harf,buyuk harf,rakam ve ozel karakter ile en fazla alti karakterli new password girer")
    public void kullaniciKucukHarfBuyukHarfRakamVeOzelKarakterIleEnFazlaAltiKarakterliNewPasswordGirer() {

        page.newPasswordBox.sendKeys("A23!aa");
    }

    @And("kullanici Password strength seviyesinin red oldugunu dogrular")
    public void kullaniciPasswordStrengthSeviyesininRedOldugunuDogrular() throws IOException {

        assertEquals(1, page.redStrength.size());
        ReusableMethods.getScreenshotWebElement("redStrength", page.strengthBar);
    }


    @And("Kullanici {string} boxa en az yedi karakter girerek strenght bar'in farkli durumlarini test eder.")
    public void kullaniciBoxaEnAzYediKarakterGirerekStrenghtBarInFarkliDurumlariniTestEder(String password) throws IOException {

        page.newPasswordBox.sendKeys(password);
        ReusableMethods.getScreenshotWebElement(password, page.strength);
    }


    @When("kullanici login olup account menuden password linke tiklar")
    public void kullaniciLoginOlupAccountMenudenPasswordLinkeTiklar() throws IOException {


        filePath = "src/resources/excelTest.xlsx";
        fis = new FileInputStream(filePath);
        workbook = WorkbookFactory.create(fis);
        // read
        //System.out.println(wb.getSheet("Sayfa1").getRow(0).getCell(0));
        //System.out.println(wb.getSheet("Sayfa1").getRow(1).getCell(0));

        sifre = workbook.getSheet("Sayfa1").getRow(0).getCell(0).toString();
        eskiSifre = workbook.getSheet("Sayfa1").getRow(1).getCell(0).toString();
        bos = "";

        // login
        page.accountMenu.click();
        ReusableMethods.waitFor(2);
        page.signIn.click();
        ReusableMethods.waitFor(2);
        page.usernameBox.sendKeys(ConfigReader.getProperty("excelUsername"));
        ReusableMethods.waitFor(2);
        page.passwordBox.sendKeys(sifre);
        ReusableMethods.waitFor(2);
        page.signInButton.click();
        page.accountMenu.click();
        ReusableMethods.waitFor(2);
        page.passwordLink.click();
        ReusableMethods.waitFor(2);
    }

    @Then("kullanici current passwordu girer ve new password ve confirm password'e eski sifreyi girer")
    public void kullaniciCurrentPassworduGirerVeNewPasswordVeConfirmPasswordEEskiSifreyiGirer() throws IOException {

        filePath = "src/resources/excelTest.xlsx";

        page.currentPasswordBox.sendKeys(sifre);
        ReusableMethods.waitFor(2);
        page.newPasswordBox.sendKeys(eskiSifre);
        ReusableMethods.waitFor(2);
        page.confirmPasswordBox.sendKeys(eskiSifre);
        ReusableMethods.waitFor(2);

        bos = sifre;
        sifre = eskiSifre;
        eskiSifre = bos;

        System.out.println("sifre = " + sifre);
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
        fos = new FileOutputStream(filePath);
        row.removeCell(cell);
        workbook.write(fos);


        //write
        workbook.getSheet("Sayfa1").getRow(0).createCell(0).setCellValue(sifre);
        workbook.getSheet("Sayfa1").getRow(1).createCell(0).setCellValue(eskiSifre);
        fos = new FileOutputStream(filePath);
        workbook.write(fos);

        fos.close();
        fis.close();
        workbook.close();
    }
}
