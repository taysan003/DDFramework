package com.datadriven.test;

import com.excel.utility.Xls_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ParameterizeTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://scgi.half.ebay.com/ws/eBayISAPI.dll?RegisterEnterInfo&usage=2943&ru=");
        driver.manage().window().maximize();

        //get testdata from excel file
        Xls_Reader reader = new Xls_Reader("G:\\SeleniumProjects\\DDFramework\\src\\test\\java\\com.testdata\\HalfEbayTestData.xls");
        int rowCount = reader.getRowCount("RegTestData"); //getting number of rows

        reader.addColumn("RegTestData", "Status");
        //parameterization
        for (int rowNum = 2; rowNum <=rowCount ; rowNum++) {


            String firstName = reader.getCellData("RegTestData", "firstname", rowNum);
            System.out.println(firstName);

            String lastName = reader.getCellData("RegTestData", "lastname", rowNum);
            System.out.println(lastName);

            String address1 = reader.getCellData("RegTestData", "address1", rowNum);
            System.out.println(address1);

            String address2 = reader.getCellData("RegTestData", "address2", rowNum);
            System.out.println(address2);

            String city = reader.getCellData("RegTestData", "city", rowNum);
            System.out.println(city);

            String state = reader.getCellData("RegTestData", "state", rowNum);
            System.out.println(state);

            String zipCode = reader.getCellData("RegTestData", "zipcode", rowNum);
            System.out.println(zipCode);

            String emailAdress = reader.getCellData("RegTestData", "emailadress", rowNum);
            System.out.println(emailAdress);

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
            Select select = new Select(driver.findElement(By.xpath("//select[@id='state']")));
            select.selectByVisibleText(state);
            driver.findElement(By.id("email")).clear();
            driver.findElement(By.id("email")).sendKeys(emailAdress);
            driver.findElement(By.id("retype_email")).clear();
            driver.findElement(By.id("retype_email")).sendKeys(emailAdress);

            reader.setCellData("RegTestData", "Status", rowNum, "Pass");//write the data into cell
        }


    }
}
