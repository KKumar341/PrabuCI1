package excelReadwrite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelReadWrite {
	Logger log= Logger.getLogger(ExcelReadWrite.class);
	
	File file;
	FileInputStream fis;
	FileOutputStream fos;
	HSSFWorkbook wb;
	HSSFSheet setSheet;
	
//	Set the path in the constructor
	
	public ExcelReadWrite(String filename) throws IOException {
		file = new File(filename);
		
		try {
			fis= new FileInputStream(file);
			wb= new HSSFWorkbook(fis);
			log.info("Sheet is loaded");
		} catch (FileNotFoundException e) {		
			e.printStackTrace();
			log.error("Unable to Load the Excel sheet");
		}
}
	
	public HSSFSheet setSheet(String sheet) {
		try{
			setSheet = wb.getSheet(sheet);
			
			log.info(sheet  +"has  been set succesfully");		
				
		} catch (Exception e) {
			log.info("Unable to load the sheet");
		}
		return setSheet;
	
	}
	
	
	public int noofhsheets() {
		int numberOfSheets = wb.getNumberOfSheets();
		return numberOfSheets;		
	}
	
	public String sheetname(int i) {
		String sheetName = wb.getSheetName(i);
		return sheetName;
		}
	
	public int getrownum(HSSFSheet sheet) {
		int lastRowNum = sheet.getLastRowNum();
		return lastRowNum;	
	}
	public int getcolnum(HSSFSheet sheet) {
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		return lastCellNum;
	}
	
	public String readvalue(int  row, int col,HSSFSheet setsheet) {
		  String readcellvalue="";
		  HSSFRow rowval = setsheet.getRow(row);
		  HSSFCell cellval = rowval.getCell(col);
		  
		  if (cellval.getCellType()== cellval.CELL_TYPE_STRING) {
			  readcellvalue = cellval.getStringCellValue();
			
		} else if(cellval.getCellType()== cellval.CELL_TYPE_NUMERIC){
			double cellvalue = cellval.getNumericCellValue();
			 readcellvalue = String.valueOf(cellvalue);
		} else if(cellval.getCellType()== cellval.CELL_TYPE_BLANK){
			readcellvalue="";
		}
		    
		return readcellvalue;	  
	  }

	public void writeValue(int row, int col, HSSFSheet sheet,String text) {
		HSSFRow rowval = sheet.getRow(row);		
		  if (rowval==null) {
				HSSFRow createRow = sheet.createRow(row);
				HSSFCell cell = createRow.getCell(col);
			
			if (cell== null) {				
				HSSFCell createCell = createRow.createCell(col);
				createCell.setCellValue(text);
			}
			
		}
		
	}
	
	public void close() throws IOException {
	    wb.write(fos);
	    fos.close();
	    System.out.println("Write");
	}
}
