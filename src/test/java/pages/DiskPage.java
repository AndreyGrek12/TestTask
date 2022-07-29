package pages;

import helpers.Waiters;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiskPage {

    protected WebDriver driver;

    @FindBy (css = ".create-resource-popup-with-anchor")
    private WebElement createButton;

    @FindBy (xpath = "//button[@aria-label='Папку']")
    private WebElement createFolderButton;

    @FindBy (css = ".confirmation-dialog__button_submit ")
    private WebElement confirmNameButton;

    @FindBy (xpath = "//span[@title='Файл для копирования.docx']")
    private WebElement fileForCopy;

    @FindBy (css = ".groupable-buttons__visible-button_name_copy")
    private WebElement copyButton;

    @FindBy (css = ".confirmation-dialog__button_submit")
    private WebElement acceptCopyButton;

    @FindBy (css = ".user-pic__image")
    private WebElement profileButton;

    @FindBy (css = ".legouser__menu-item_action_exit")
    private WebElement logoutButton;

    @FindBy (css = ".upload-button__attach")
    private WebElement uploadButton;

    @FindBy (xpath = "//span[@title='FileToUpload.txt']")
    private WebElement fileToUpload;

    @FindBy (xpath = "//div[@data-key='item-1']")
    private WebElement watchFileButton;

    @FindBy (xpath = "//div[@title='Новая папка']")
    private WebElement folderButton;

    @FindBy (xpath = "//div[@aria-label='Новая папка']")
    private WebElement folder;

    public DiskPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public DiskPage clickCreateButton () {
        createButton.click();
        return this;
    }

    public DiskPage createFolder () {
        createFolderButton.click();
        return this;
    }

    public DiskPage confirmFolderCreation () {
        confirmNameButton.click();
        return this;
    }

    public DiskPage clickOnFileForCopy() {
        Waiters.waitForVisibility(5,driver, folder);
        fileForCopy.click();
        return this;
    }

    public DiskPage clickCopyButton () {
        copyButton.click();
        return this;
    }

    public DiskPage chooseFolder () {
        folderButton.click();
        return this;
    }

    public DiskPage acceptCopy () {
        acceptCopyButton.click();
        return this;
    }

    public void openFolder () {
        Actions actions = new Actions(driver);
        actions.doubleClick(folder).perform();
    }

    public String getFileName() {
        Waiters.waitForVisibility(5,driver,fileForCopy);
        return fileForCopy.getAttribute("title");
    }

    public DiskPage openProfileMenu () {
        profileButton.click();
        return this;
    }

    public void logout () {
        logoutButton.click();
    }

    public boolean fileShouldBeVisible () {
        Waiters.waitForVisibility(5,driver,fileForCopy);
        return fileForCopy.isDisplayed();
    }

    public DiskPage uploadFile () {
        uploadButton.sendKeys("C:\\FileToUpload.txt");
        return this;
    }

    public DiskPage rightClickOnFileToUpload() {
        Waiters.waitForVisibility(5,driver,fileToUpload);
        Actions actions = new Actions(driver);
        actions.contextClick(fileToUpload).perform();
        return this;
    }

    public void watchFile () {
        watchFileButton.click();
    }
}
