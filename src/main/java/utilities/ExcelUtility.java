package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public Workbook book;
	public Sheet sheet;
	
	public static final String SHEET_PATH="";
	
	public Object[][] getDataFromExcel(String sheetName)
	{
		Object [][] data=null;
		
		try {
			FileInputStream ip= new FileInputStream(SHEET_PATH);
		book=WorkbookFactory.create(ip);
			sheet=book.getSheet(sheetName);
		//String sheetnamed=	sheet.getSheetName();
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	 for(int i=0;i<sheet.getLastRowNum();i++)
	 {
		 for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
		 {
			 data[i][k]=sheet.getRow(i+1).getCell(k);
		 }
	 }
		return data;
	}
	

}
