package simi.gestoria.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class DataSheet {

	public String getCellValue(int rowNumber, int cellNumber) throws IOException {
		File file = new File("datos.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		XSSFSheet newSheet = newWorkbook.getSheetAt(0);
		XSSFRow row = newSheet.getRow(rowNumber);
		XSSFCell cell = row.getCell(cellNumber);
		return cell.getStringCellValue();
	}
	
	
	public void writeCellValue(int Sheet,int rowNumber, int cellNumber, String value) throws IOException {
		File file = new File("datos.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
		XSSFSheet newSheet = newWorkbook.getSheetAt(Sheet);
		XSSFRow row = newSheet.getRow(rowNumber);
		XSSFCell Cell = row.createCell(cellNumber);
		Cell.setCellValue(value);
		//inputStream.close();
		FileOutputStream outputStream = new FileOutputStream(file);
		newWorkbook.write(outputStream);
		outputStream.close();
		}
	}
	
