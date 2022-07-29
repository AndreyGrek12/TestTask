package pages;

import helpers.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    protected WebDriver driver;

    @FindBy (css = ".Textinput-Control")
    private WebElement loginField;

    @FindBy (css = ".Button2_type_submit")
    private WebElement submitLoginButton;

    @FindBy (css = "#passp-field-passwd")
    private WebElement passwordField;

    @FindBy (xpath = "//button[@data-type='login']")
    private WebElement mailButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage inputLogin(String login) {
        Waiters.waitForVisibility(5, driver, loginField);
        loginField.sendKeys(login);
        return this;
    }

    public LoginPage confirmLogin() {
        submitLoginButton.click();
        return this;
    }

    public LoginPage inputPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public MainPage confirmPassword() {
        submitLoginButton.click();
        return new MainPage(driver);
    }

    public LoginPage chooseMail() {
        Waiters.waitForVisibility(5,driver,mailButton);
        mailButton.click();
        return this;
    }
}
