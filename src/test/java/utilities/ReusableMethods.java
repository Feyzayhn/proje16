package utilities;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static utilities.Driver.driver;

public class ReusableMethods {

    //========ScreenShot(Sayfanın resmini alma)=====//
    public static String getScreenshot(String name) throws IOException {

        // yinelemeyi önlemek için ekran görüntüsünü geçerli tarihle adlandırma
        String date = new SimpleDateFormat("yyyy-MM-dd-HHmm").format(new Date());

        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);

        //ekran görüntüsü konumunun tam yolu
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + "_" + date + ".png";
        File finalDestination = new File(target);

        //ekran görüntüsünü verilen yola kaydedin
        FileUtils.copyFile(source, finalDestination);
        return target;
    }//

    //========ScreenShot Web Element(Bir webelementin resmini alma)=====//
    public static String getScreenshotWebElement(String name, WebElement element) throws IOException {
        String date = new SimpleDateFormat("yyyy-MM-dd-hhmm").format(new Date());

        // TakesScreenshot, ekran görüntüsünü alan bir selenyum arayüzüdür.
        File source = element.getScreenshotAs(OutputType.FILE);

        // ekran görüntüsü konumunun tam yolu
        String wElementSS = System.getProperty("user.dir") + "/target/WElementScreenshots/" + name + "_" + date + ".png";
        File finalDestination = new File(wElementSS);

        // ekran görüntüsünü verilen yola kaydedin
        FileUtils.copyFile(source, finalDestination);
        return wElementSS;
    }//

    //========Switching Window(Pencereler arası geçiş)=====//
    public static void switchToWindow(String targetTitle) {

        String origin = Driver.getDriver().getWindowHandle();

        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }//


    //========Hover Over(Elementin üzerinde beklemek)=====//
    public static void hover(WebElement element) {

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();

    }//

    //==========Return a list of string given a list of Web Element====////
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }//

    //========Returns the Text of the element given an element locator==//
    public static List<String> getElementsText(By locator) {

        List<WebElement> elems = Driver.getDriver().findElements(locator);

        List<String> elemTexts = new ArrayList<>();

        for (WebElement el : elems) {

            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }//

    //   HARD WAIT WITH THREAD.SLEEP
    //   waitFor(5);  => waits for 5 second


    //===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }//

    public static WebElement waitForClickable(By locator, int timeout) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));

        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }//


    public static void waitForPageToLoad(long timeout) { // method
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };

        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
            wait.until(expectation);

        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }//

    public static Faker getFaker() { // getFaker method

        Faker faker;
        return faker = new Faker();
    }//

    public static Actions getActions() { //getActions method

        Actions actions;
        return actions = new Actions(Driver.getDriver());
    }//

    public static Select select(WebElement ddm) { //select method

        Select select;

        return select = new Select(ddm);
    }//

    public static void jsScrollClick(WebElement webElement) {  //kaydir ve tikla
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        try {
            webElement.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].scrollIntoView(true);", webElement);
            js.executeScript("arguments[0].click()", webElement);
        }
    }

    public static void waitFor(int sec) { //bekle

        try {
            Thread.sleep(sec * 1000);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    public static Random random() { //

        Random random;
        return random = new Random();
    }

    public static void jsScroll(WebElement webElement) {  //

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }


    public static void toBeClickableWait(WebElement webElement) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void visibilityOfWait(WebElement webElement) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void visibilityOfElementLocatedWait(By located) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(located));
    }

    public static void scrollDownJs() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,250)", "");
    }

    public static void enterField(String fieldName, String fieldValue) {
        By locator = By.xpath("//*[.='" + fieldName + "']//following-sibling::input");
        driver.findElement(locator).sendKeys(fieldValue);
    }
    public static void sayfaKucult() throws AWTException {
        Robot robot = new Robot();
        for (int i = 0; i < 2; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL); //CTRL ye tiklandi
            robot.keyPress(KeyEvent.VK_SUBTRACT); // - ye tiklandi
            robot.keyRelease(KeyEvent.VK_SUBTRACT); // CTRL yi birakti
            robot.keyRelease(KeyEvent.VK_CONTROL); //- yi birakti
            // CTRL (-) ye basılarak ekran belirlenen miktarda küçültülmüş oldu.
        }
    }
}