package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class ExcelData {
	
	public Object[][] custData(String path, String sheetName) throws IOException{
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet xs = wb.getSheet(sheetName);
		int rowCount = xs.getPhysicalNumberOfRows();
		Object[][] data = new Object[rowCount-1][1];
		for(int i=1;i<rowCount;i++)
		{
			PojoClass details = new PojoClass();
			details.dealerNameTxtBox = xs.getRow(i).getCell(0).getStringCellValue();
			details.userNameTxtBox= xs.getRow(i).getCell(1).getStringCellValue();
			details.phoneNoTxtBox= xs.getRow(i).getCell(2).getStringCellValue();
			details.panNumberTxtBox= xs.getRow(i).getCell(3).getStringCellValue();
			details.addressTxtBox= xs.getRow(i).getCell(4).getStringCellValue();
			details.pincodeTxtBox= xs.getRow(i).getCell(5).getStringCellValue();
			details.accounNoTxtBox= xs.getRow(i).getCell(6).getStringCellValue();
			details.ifscTxtBox= xs.getRow(i).getCell(7).getStringCellValue();
			details.accountHolderName= xs.getRow(i).getCell(8).getStringCellValue();
			details.enrollmentFormUpload= xs.getRow(i).getCell(9).getStringCellValue();
			details.panCardUpload= xs.getRow(i).getCell(10).getStringCellValue();
			details.kycUpload= xs.getRow(i).getCell(11).getStringCellValue();
			details.chequeUpload= xs.getRow(i).getCell(12).getStringCellValue();
			details.photoUpload= xs.getRow(i).getCell(13).getStringCellValue();
			details.businessProofUpload= xs.getRow(i).getCell(14).getStringCellValue();
			details.engagementLetterUpload= xs.getRow(i).getCell(15).getStringCellValue();
			
			data[i-1][0]=details;
		}
		wb.close();
		fis.close();
		return data;
	}
	
//	public String[][] getCustDet(String path , String SheetName) throws IOException{
//		File f = new File(path);
//		FileInputStream fis = new FileInputStream(f);
//		XSSFWorkbook wb = new XSSFWorkbook(fis);
//		XSSFSheet xs = wb.getSheet(SheetName);
//		int rowCount = xs.getPhysicalNumberOfRows();
//		int coloumnCount = xs.getRow(0).getPhysicalNumberOfCells();
//		String[][] data = new String[rowCount-1][coloumnCount];
//		for (int i=1;i<rowCount;i++)
//		{
//			for (int j=0;j<coloumnCount;j++)
//			{
//				Cell cell = xs.getRow(i).getCell(j);
//				if(cell==null)
//				{
//					data[i-1][j]="";
//				}
//				else {
//				data[i-1][j]=cell.getStringCellValue();
//				}
//				
//			}
//		}
//		wb.close();
//		fis.close();
//		return data;
//		}
	
	@DataProvider(name="userData",parallel=true)
	public Object[][] excelReader() throws IOException
	{
		ConfigReader cr = new ConfigReader();
		String file = cr.get("path");
		String sheetDetail = cr.get("sheetName");
		//ExcelData ed = new ExcelData();
		return custData(file,sheetDetail);
	}

}
