package com.datadriven.test;

import com.excel.utility.Xls_Reader;

public class ParameterizeTest {

    public static void main(String[] args) {

        //get testdata from excel file
        Xls_Reader reader = new Xls_Reader("G:\\SeleniumProjects\\DDFramework\\src\\test\\java\\com.testdata\\HalfEbayTestData.xls");
        int rowCount = reader.getRowCount("RegTestData"); //getting number of rows

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
        }
    }
}
