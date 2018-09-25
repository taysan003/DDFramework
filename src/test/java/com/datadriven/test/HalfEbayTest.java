package com.datadriven.test;


import com.test.utility.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class HalfEbayTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=");
    }

    @DataProvider
    public Iterator<Object[]> getTestData(){ // we need to iterate each and every element
        ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
        return testData.iterator();
    }

    @Test(dataProvider = "getTestData")
    public void halfEbayRegPageTest(String firstName, String lastName, String address1, String address2,
                                    String city, String zipCode, String state, String emailAdress){
            //entering data
            driver.findElement(By.id("firstname")).clear();
            driver.findElement(By.id("firstname")).sendKeys(firstName);
            driver.findElement(By.id("lastname")).clear();
            driver.findElement(By.id("lastname")).sendKeys(lastName);
            driver.findElement(By.id("address1")).clear();
            driver.findElement(By.id("address1")).sendKeys(address1);
            driver.findElement(By.id("address2")).clear();
            driver.findElement(By.id("address2")).sendKeys(address2);
            driver.findElement(By.id("city")).clear();
            driver.findElement(By.id("city")).sendKeys(city);
            driver.findElement(By.id("zip")).clear();
            driver.findElement(By.id("zip")).sendKeys(zipCode);
            Select select = new Select(driver.findElement(By.id("state")));
            select.selectByVisibleText(state);
            driver.findElement(By.id("email")).clear();
            driver.findElement(By.id("email")).sendKeys(emailAdress);
            driver.findElement(By.id("retype_email")).clear();
            driver.findElement(By.id("retype_email")).sendKeys(emailAdress);



    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
