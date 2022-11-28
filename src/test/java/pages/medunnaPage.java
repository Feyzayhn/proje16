package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class medunnaPage {

    public medunnaPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class='appointment-btn scrollto']")
    public WebElement Appointment;
    @FindBy(xpath = "//*[@id='firstName']")
    public WebElement FirstName;
    @FindBy(xpath = "//*[@id='ssn']")
    public WebElement SSN;

    @FindBy(xpath ="//*[@id='phone']")
    public WebElement Phone ;
    @FindBy(xpath ="//*[@id='lastName']")
    public WebElement LastName ;
    @FindBy(xpath ="//*[@id='email']")
    public WebElement Email ;
    @FindBy(xpath ="//*[@id='appoDate']")
    public WebElement Date ;
}