package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DockviewerPage {

    protected WebDriver driver;

    @FindBy (xpath = "//p[text()='Текст для проверки']")
    private WebElement text;

    public DockviewerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getText () {
        return text.getText();
    }
}
