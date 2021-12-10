package com.cybertek.tests.day17_upload_js_executer;

import com.cybertek.tests.TestBase;
import com.cybertek.utils.ConfigurationReader;
import org.testng.annotations.Test;

public class Guru99UploadTest extends TestBase {

    @Test
    public void uploadFileTest(){
        driver.get(ConfigurationReader.getProperty("guru99upload.url"));
    }


}

