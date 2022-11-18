package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import pages.MedunnaPageS;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.*;

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
            Assert.assertFalse(page.notMatchTextMessage.isDisplayed());
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

        Assert.assertEquals(4, page.limeGreenStrength.size());
        ReusableMethods.getScreenshotWebElement("limegreenSS", page.strengthBar);
    }

    @And("kullanici New password'a kucuk harf ekler")
    public void kullaniciNewPasswordAKucukHarfEkler() {

        page.newPasswordBox.sendKeys("aa");
    }

    @And("kullanici Password strength seviyesinin green oldugunu dogrular")
    public void kullaniciPasswordStrengthSeviyesininGreenOldugunuDogrular() throws IOException {

        Assert.assertEquals(5, page.greenStrength.size());
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

    //String sifre = "Team16kullanici!";
    String sifre = "Kullaniciteam16!";
    //String eskiSifre = "Kullaniciteam16!";
    String eskiSifre = "Team16kullanici!";

    @And("kullanici mevcut sifreyi current password box'a girer")
    public void kullaniciMevcutSifreyiCurrentPasswordBoxAGirer() {

        page.currentPasswordBox.sendKeys(sifre);
    }

    @And("kullanici new password box'a eski sifreyi girer")
    public void kullaniciNewPasswordBoxAEskiSifreyiGirer() {

        page.newPasswordBox.sendKeys(eskiSifre);
    }

    @And("kullanici new password confirmation box'a ayni sifreyi girer")
    public void kullaniciNewPasswordConfirmationBoxAAyniSifreyiGirer() {

        page.confirmPasswordBox.sendKeys(eskiSifre);
    }

    @And("kullanici save butonuna tiklar")
    public void kullaniciSaveButonunaTiklar() {


        page.saveButton.click();
    }

    @And("kullanici Password changed! uyarisinin gorunur olmadigini dogrular")
    public void kullaniciPasswordChangedUyarisininGorunurOlmadiginiDogrular() {

        try {
            Assert.assertFalse(page.passwordChangedMessage.isDisplayed());

        } catch (Exception e) {

            System.out.println("Eski sifre kullanilabildi");
        }

    }

    @Given("excel test")
    public void excelTest() throws IOException {

        String filePath = "src/resources/sifre.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook wb = WorkbookFactory.create(fis);

        System.out.println(wb.getSheet("Sayfa1").getRow(0).getCell(0));
        System.out.println(wb.getSheet("Sayfa1").getRow(1).getCell(0));


        String sifre = wb.getSheet("Sayfa1").getRow(0).getCell(0).toString();
        String eskiSifre = wb.getSheet("Sayfa1").getRow(1).getCell(0).toString();
        String bos = "";

        bos = sifre;
        sifre = eskiSifre;
        eskiSifre = bos;

        System.out.println("sifre = " + sifre);
        System.out.println("eskiSifre = " + eskiSifre);

        Sheet sheet = wb.getSheet("Sayfa1");
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        row.removeCell(cell);
        FileOutputStream fos = new FileOutputStream(filePath);
        wb.write(fos);


        Sheet sheet1 = wb.getSheet("Sayfa1");
        Row row2 = sheet1.getRow(1);
        Cell cell2 = row2.getCell(0);
        fos = new FileOutputStream(filePath);
        row2.removeCell(cell2);
        wb.write(fos);


        wb.getSheet("Sayfa1").getRow(0).createCell(0).setCellValue(sifre);
        wb.getSheet("Sayfa1").getRow(1).createCell(0).setCellValue(eskiSifre);
        fos = new FileOutputStream(filePath);
        wb.write(fos);

        fos.close();
        fis.close();
        wb.close();
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

        Assert.assertTrue(page.notMatchTextMessage.isDisplayed());
        ReusableMethods.getScreenshotWebElement("dontMatch", page.notMatchTextMessage);
    }

    @And("kullanici kucuk harf,buyuk harf,rakam ve ozel karakter ile en fazla alti karakterli new password girer")
    public void kullaniciKucukHarfBuyukHarfRakamVeOzelKarakterIleEnFazlaAltiKarakterliNewPasswordGirer() {

        page.newPasswordBox.sendKeys("A23!aa");
    }

    @And("kullanici Password strength seviyesinin red oldugunu dogrular")
    public void kullaniciPasswordStrengthSeviyesininRedOldugunuDogrular() throws IOException {

        Assert.assertEquals(1, page.redStrength.size());
        ReusableMethods.getScreenshotWebElement("redStrength", page.strengthBar);
    }
}
