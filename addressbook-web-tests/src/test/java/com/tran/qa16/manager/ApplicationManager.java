package com.tran.qa16.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    SessionHelper sessionHelper;
    GroupHelper groupHelper;
    private WebDriver wd;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void start() {
        if(browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        }else if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        }else if(browser.equals(BrowserType.EDGE)) {
            wd = new EdgeDriver();
        }

        wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        sessionHelper= new SessionHelper(wd);
        sessionHelper.openSite("http://localhost/addressbook");
        sessionHelper.login("admin", "secret");
        groupHelper = new GroupHelper(wd);
    }

//    public void click(By locator) {
//        wd.findElement(locator).click();
//    }

    public void stop() {
   //     wd.quit();
    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public  boolean isElementsPresent(By locator){
        return wd.findElements(locator).size()>0;
    }


    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
