package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {
static String filepath=".\\testData\\TestCases.xlsx";
public static String readExcelData(int row,int cellNum){
	String data=" ";
	try{
		Workbook wb=WorkbookFactory.create(new FileInputStream(new File(filepath)));
		data=wb.getSheet("Sheet1").getRow(row).getCell(cellNum).getStringCellValue();
				
	}
catch(EncryptedDocumentException e)		{
	e.printStackTrace();
	}
	catch (InvalidFormatException e) {
		e.printStackTrace();
	}
	catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	catch(IOException e){
		e.printStackTrace();
	}
	

return data;
}}
