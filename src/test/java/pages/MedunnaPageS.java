package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

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

}
