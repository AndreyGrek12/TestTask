package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private final WebDriver driver;

    @FindBy (css = ".home-link.desk-notif-card__login-new-item_enter")
    private WebElement loginButton;

    @FindBy (xpath = "//a[@data-statlog='notifications.mail.login.disk']")
    private WebElement diskButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage openLoginScreen() {
        loginButton.click();
        return new LoginPage(driver);
    }

    public void openDisk() {
        diskButton.click();
    }
}
