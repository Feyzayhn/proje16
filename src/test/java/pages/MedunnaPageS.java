package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MedunnaPageS {


    public MedunnaPageS() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#account-menu")
    public WebElement accountMenu;

    @FindBy(xpath = "//*[.='Sign in']")
    public WebElement signIn;

    @FindBy(xpath = "//*[@name='username']")
    public WebElement usernameBox;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement passwordBox;

    @FindBy(css = ".btn.btn-primary")
    public WebElement signInButton;

    @FindBy(css = ".dropdown-menu-right.show>:nth-child(2)>span")
    public WebElement passwordLink;

    @FindBy(xpath = "//*[@name='currentPassword']")
    public WebElement currentPasswordBox;

    @FindBy(css = "#newPassword")
    public WebElement newPasswordBox;

    @FindBy(css = "#confirmPassword")
    public WebElement confirmPasswordBox;

    @FindBy(css = ".btn.btn-success>span")
    public WebElement saveButton;

    // @FindBy(xpath = "//*[contains(text(), 'Password changed')]")
    @FindBy(xpath = "//*[contains(text(), 'Password changed!')]")
    public WebElement passwordChangedMessage;


    // Password Strength
    @FindBy(css = "#strengthBar")
    public WebElement strengthBar;

    @FindBy(xpath = "//li[@style='background-color: rgb(255, 0, 0);']") // size = 1
    public List<WebElement> redStrength;

    @FindBy(xpath = "//li[@style='background-color: rgb(255, 153, 0);']") // size = 2
    public List<WebElement> orangeStrength;

    @FindBy(xpath = "//li[@style='background-color: rgb(255, 255, 0);']") // size = 3
    public List<WebElement> yellowStrength;

    @FindBy(xpath = "//li[@style='background-color: rgb(153, 255, 0);']") // size = 4
    public List<WebElement> limeGreenStrength;

    @FindBy(xpath = "//li[@style='background-color: rgb(0, 255, 0);']") // size = 5
    public List<WebElement> greenStrength;
}
