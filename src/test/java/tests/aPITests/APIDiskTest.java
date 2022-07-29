package tests.aPITests;

import org.testng.annotations.Test;
import requests.DiskRequests;

public class APIDiskTest {

    @Test
    public void copyFileTest() {
        DiskRequests.createFolder();
        DiskRequests.copyFile();
        DiskRequests.renameFile();
        DiskRequests.deleteFolder("/Новая папка", 202);
    }
}
