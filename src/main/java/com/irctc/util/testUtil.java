package com.irctc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.TakesScreenshot;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.irctc.base.testBase;

public class testUtil extends testBase{

	public static String filePath = System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testData.xlsx";
	public static Workbook book;
	public static Sheet sheet;
	public static String screenshotName;
	
	public void switchToFrame(String frmNM) {
		driver.switchTo().frame(frmNM);
	}
	
	public static Object[][] getTestData(String SheetName){
		FileInputStream fis=null;
		try {
			System.out.println(filePath);
			fis = new FileInputStream(filePath);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(fis);
			System.out.println("Created book");
		}catch(InvalidFormatException e) {
			e.printStackTrace();
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		sheet = book.getSheet(SheetName);
		
		Object[][]data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				System.out.println(data[i][j]);
			}
		}
		return data;
	}
	
	public static void takeScreenshot() throws IOException{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 Date d = new Date();
         screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";  
		File destFile = new File(System.getProperty("user.dir")+"\\testResults\\screenshots\\"
		+screenshotName);
		FileUtils.copyFile(srcFile, destFile);
	}
}
