package com.datadriven.test;

import com.excel.utility.Xls_Reader;

public class ExcelOperations {

    public static void main(String[] args) {


        //get testdata from excel file
        Xls_Reader reader = new Xls_Reader("G:\\SeleniumProjects\\DDFramework\\src\\test\\java\\com.testdata\\HalfEbayTestData.xls");


        if (!reader.isSheetExist("HomePage")){
            reader.addSheet("HomePage");
        }

        int colCount = reader.getColumnCount("RegTestData");
        System.out.println("Total cols presented in RegTestData : "+colCount);
        System.out.println(reader.getCellRowNum("RegTestData", "firstname", "Tom"));
    }


}
