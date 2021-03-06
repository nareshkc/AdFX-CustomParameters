package com.weather.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import com.Genaral.Driver;

public class Write_result extends Driver{
	public void WriteResult( String sheetName, String tmp_val, int i, int resultColIndex) {
		String Path =null;
		if(Excel_Path.equals("Login"))
		{
			Path =properties.getProperty("RegisterExcelFilePath");
		}else
		{
			Path =properties.getProperty("AnonymousExcelFilePath");
		}

		try {

			FileInputStream file = new FileInputStream(Path);
			HSSFWorkbook workbook = new HSSFWorkbook(file);

			HSSFSheet sheet = workbook.getSheet(sheetName);

			Cell searchText3 = sheet.getRow(i).getCell(resultColIndex);
			searchText3.setCellValue(tmp_val);

			//			    Cell searchText4 = sheet.getRow(rowIndex).getCell(valueColIndex);
			//			    searchText4.setCellValue(Val);

			file.close();

			FileOutputStream outFile = new FileOutputStream(Path);
			workbook.write(outFile);
			outFile.close();

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}



}
