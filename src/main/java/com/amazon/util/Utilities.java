package com.amazon.util;

import com.amazon.base.Base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;


public class Utilities extends Base {
    private static Logger log = LogManager.getLogger(Utilities.class);

    public  Object[][] readExcel(String filePath, String fileName, String sheetName) throws IOException {

        File file = new File(filePath + "/" + fileName);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook book = null;
        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        if (fileExtensionName.equals(".xlsx"))
        {
            book = new XSSFWorkbook(inputStream);
        }
        else if (fileExtensionName.equals(".xls"))
        {
            book = new HSSFWorkbook(inputStream);
        }
        Sheet workBookSheet = book.getSheet(sheetName);
        Object[][] data = new Object[workBookSheet.getLastRowNum()][workBookSheet.getRow(0).getLastCellNum()];
         log.info("number of rows " +workBookSheet.getLastRowNum());
        log.info("Number of columns " +workBookSheet.getRow(0).getLastCellNum());
        for (int i = 0; i < workBookSheet.getLastRowNum(); i++)
        {
            for (int j=0; j < workBookSheet.getRow(0).getLastCellNum(); j++)
            {
                    data[i][j] = workBookSheet.getRow(i + 1).getCell(j).toString();
            }
        }
        return data;
    }

    public static void takeScreenShot() throws IOException
    {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String currDir =System.getProperty("user.dir");
        FileUtils.copyFile(srcFile,new File(currDir +"/screenshots/" +".png"));

    }


}

