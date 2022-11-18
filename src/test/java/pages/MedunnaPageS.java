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

    @FindBy(id = "login-item")
    public WebElement signInId;

    @FindBy(xpath = "//*[.='Sign in']")
    public WebElement signIn;

    @FindBy(xpath = "//*[@name='username']") //css input[name=username]
    public WebElement usernameBox;

    @FindBy(xpath = "//*[@name='password']") // css input[name=password]
    public WebElement passwordBox;

    @FindBy(css = ".btn.btn-primary") // xpath //*[@type='submit']
    public WebElement signInButton;

    // xpath  //div//a[@class='dropdown-item']//span[.='Password']
    @FindBy(css = ".dropdown-menu-right.show>:nth-child(2)>span")
    public WebElement passwordLink;


    @FindBy(xpath = "//*[@name='currentPassword']") // css input[name=currentPassword]
    public WebElement currentPasswordBox;

    @FindBy(css = "#newPassword")   // xpath //*[@id='newPassword']
    public WebElement newPasswordBox;

    @FindBy(css = "#confirmPassword") // xpath //*[@id='confirmPassword']
    public WebElement confirmPasswordBox;

    @FindBy(css = ".btn.btn-success>span") // xpath //button//span[.='Save']
    public WebElement saveButton;

    // @FindBy(xpath = "//*[contains(text(), 'Password changed')]")
    @FindBy(xpath = "//*[contains(text(), 'Password changed!')]")
    public WebElement passwordChangedMessage;


    @FindBy(css = "div.col-md-8")
    public WebElement passwordScreen;

    // Password Strength
    @FindBy(css = "#strengthBar")
    public WebElement strengthBar;

    @FindBy(css = "#strength")
    public WebElement strength;

    @FindBy(xpath = "//li[@style='background-color: rgb(255, 0, 0);']") // size = 1
    public List<WebElement> redStrength;  // css  #strengthBar>:nth-child(1)

    //@FindBy(xpath = "//li[@style='background-color: rgb(255, 153, 0);']")
    //public WebElement orangeStrength;

    @FindBy(xpath = "//li[@style='background-color: rgb(255, 153, 0);']") // size = 2
    public List<WebElement> orangeStrengthList;

    @FindBy(xpath = "//li[@style='background-color: rgb(255, 255, 0);']") // size = 3
    public List<WebElement> yellowStrength;

    @FindBy(xpath = "//li[@style='background-color: rgb(153, 255, 0);']") // size = 4
    public List<WebElement> limeGreenStrength;

    @FindBy(xpath = "//li[@style='background-color: rgb(0, 255, 0);']") // size = 5
    public List<WebElement> greenStrength;

    @FindBy(xpath = "//*[.='The password and its confirmation do not match!']")
    public WebElement notMatchTextMessage;  // css  .invalid-feedback
}
