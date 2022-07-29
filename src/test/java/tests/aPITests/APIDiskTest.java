package tests.aPITests;

import org.testng.annotations.Test;
import requests.DiskRequests;

public class APIDiskTest {

    @Test
    public void copyFileTest() {
        String folderName = "папка";

        DiskRequests.createFolder(folderName);
        DiskRequests.copyFile(folderName);
        DiskRequests.renameFile(folderName);
        DiskRequests.deleteFolder("/" + folderName, 202);
    }
}
