package tests.aPITests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import requests.DiskRequests;

public class APIDiskTest {

    String folderName = "папка";

    @Test
    public void copyFileTest() {
        DiskRequests.createFolder(folderName);
        DiskRequests.copyFile(folderName);
        DiskRequests.renameFile(folderName);
    }

    @AfterMethod
    public void logoutAndCloseChrome() {
        DiskRequests.deleteFolder("/" + folderName);
    }
}
