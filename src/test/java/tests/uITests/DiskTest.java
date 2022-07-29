package tests.uITests;

import helpers.WindowUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import requests.DiskRequests;

public class DiskTest extends BaseTest {

    public MainPage mainPage;
    public LoginPage loginPage;
    public DiskPage diskPage;
    public DockviewerPage dockviewerPage;

    @BeforeMethod
    public void setPages() {
        mainPage = new MainPage(driver);
        diskPage = new DiskPage(driver);
        loginPage = new LoginPage(driver);
        dockviewerPage = new DockviewerPage(driver);
        driver.get("https://yandex.ru/");

        mainPage.openLoginScreen()
                .chooseMail()
                .inputLogin("mailfortesting1")
                .confirmLogin()
                .inputPassword("12344321qwerREWQ")
                .confirmPassword()
                .openDisk();
        WindowUtils.focusTab(driver, 2);
    }

    @Test
    public void copyFileTest () {
        diskPage.clickCreateButton()
                .createFolder()
                .confirmFolderCreation()
                .clickOnFileForCopy()
                .clickCopyButton()
                .chooseFolder()
                .acceptCopy()
                .openFolder();
        Assert.assertTrue(diskPage.fileShouldBeVisible(), "Файл не скопирован в папку");
        Assert.assertEquals(diskPage.getFileName(),
                "Файл для копирования.docx",
                "Названия не совпадают");
        DiskRequests.deleteFolder("/Новая папка", 202);
    }

    @Test
    public void uploadFileTest () {
        diskPage.uploadFile()
                .rightClickOnFileToUpload()
                .watchFile();
        WindowUtils.focusTab(driver, 3);
        Assert.assertEquals("Текст для проверки",
                dockviewerPage.getText(),
                "Текст не совпадает");
        WindowUtils.focusTab(driver,2);
        DiskRequests.deleteFolder("/FileToUpload.txt", 204);
    }

    @AfterMethod
    public void logoutAndCloseChrome() {
        diskPage.openProfileMenu()
                .logout();
        driver.quit();
    }
}
