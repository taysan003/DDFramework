package com.datadriven.test;

import com.excel.utility.Xls_Reader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenTest {

    public static void main(String[] args) {

        Xls_Reader reader = new Xls_Reader("G:\\SeleniumProjects\\DDFramework\\src\\test\\java\\com.testdata\\HalfEbayTestData.xls");
        String firstName = reader.getCellData("RegTestData", "firstname", 2);
        System.out.println(firstName);


        String lastname = reader.getCellData("RegTestData", "lastname", 2);
        System.out.println(lastname);


        String address1 = reader.getCellData("RegTestData", "address1", 2);
        System.out.println(address1);


        String address2 = reader.getCellData("RegTestData", "address2", 2);
        System.out.println(address2);


        String city = reader.getCellData("RegTestData", "city", 2);
        System.out.println(city);


        String state = reader.getCellData("RegTestData", "state", 2);
        System.out.println(state);


        String zipcode = reader.getCellData("RegTestData", "zipcode", 2);
        System.out.println(zipcode);


        String emailadress = reader.getCellData("RegTestData", "emailadress", 2);
        System.out.println(emailadress);

       /* WebDriver driver = new ChromeDriver();
        driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=");
        driver.manage().window().maximize();*/


    }
    }

