package com.test.utility;

import com.excel.utility.Xls_Reader;

import java.util.ArrayList;

public class TestUtil {
   static Xls_Reader reader;

    public static ArrayList<Object[]> getDataFromExcel(){
        ArrayList<Object[]> myData = new ArrayList<Object[]>();
        try {
            reader = new Xls_Reader(System.getProperty("user.dir") +
                          "G:\\SeleniumProjects\\DDFramework\\src\\test\\java\\com.testdata\\HalfEbayTestData.xls");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int rowNum = 2; rowNum <=reader.getRowCount("RegTestData"); rowNum++) {
            String firstName = reader.getCellData("RegTestData", "firstname", rowNum);
            String lastName = reader.getCellData("RegTestData", "lastname", rowNum);
            String address1 = reader.getCellData("RegTestData", "address1", rowNum);
            String address2 = reader.getCellData("RegTestData", "address2", rowNum);
            String city = reader.getCellData("RegTestData", "city", rowNum);
            String state = reader.getCellData("RegTestData", "state", rowNum);
            String zipCode = reader.getCellData("RegTestData", "zipcode", rowNum);
            String emailAdress = reader.getCellData("RegTestData", "emailadress", rowNum);

            Object ob[] = {firstName, lastName, address1, address2, city, state, zipCode, emailAdress};
            myData.add(ob);
        }
        return myData;
    }
}
