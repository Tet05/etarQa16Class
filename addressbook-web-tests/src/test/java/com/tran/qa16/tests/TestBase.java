package com.tran.qa16.tests;

import com.tran.qa16.manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class TestBase {

   protected static ApplicationManager app
           = new ApplicationManager(System
           .getProperty("browser", BrowserType.EDGE));

    @BeforeSuite
    public void setUp(){
        app.start();

    }



    @AfterSuite
    public void tearDown(){
        app.stop();
    }


}
