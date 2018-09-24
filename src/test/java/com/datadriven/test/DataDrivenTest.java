package com.datadriven.test;

import com.excel.utility.Xls_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DataDrivenTest {

    public static void main(String[] args) {

        //get testdata from excel file
        Xls_Reader reader = new Xls_Reader("G:\\SeleniumProjects\\DDFramework\\src\\test\\java\\com.testdata\\HalfEbayTestData.xls");
        String firstName = reader.getCellData("RegTestData", "firstname", 2);
        System.out.println(firstName);

        String lastName = reader.getCellData("RegTestData", "lastname", 2);
        System.out.println(lastName);

        String address1 = reader.getCellData("RegTestData", "address1", 2);
        System.out.println(address1);

        String address2 = reader.getCellData("RegTestData", "address2", 2);
        System.out.println(address2);

        String city = reader.getCellData("RegTestData", "city", 2);
        System.out.println(city);

        String state = reader.getCellData("RegTestData", "state", 2);
        System.out.println(state);

        String zipCode = reader.getCellData("RegTestData", "zipcode", 2);
        System.out.println(zipCode);

        String emailAdress = reader.getCellData("RegTestData", "emailadress", 2);
        System.out.println(emailAdress);

        WebDriver driver = new ChromeDriver();
        driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=");
        driver.manage().window().maximize();

        driver.findElement(By.id("firstname")).sendKeys(firstName);
        driver.findElement(By.id("lastname")).sendKeys(lastName);
        driver.findElement(By.id("address1")).sendKeys(address1);
        driver.findElement(By.id("address2")).sendKeys(address2);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("zip")).sendKeys(zipCode);
        Select select = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        select.selectByVisibleText(state);

        driver.findElement(By.id("email")).sendKeys(emailAdress);
        driver.findElement(By.id("retype_email")).sendKeys(emailAdress);
    }
    }

