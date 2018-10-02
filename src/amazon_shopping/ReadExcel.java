package amazon_shopping;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReadExcel {
	static int  emailColumnIndex ;
	static int PasswordColumnIndex ;
	static String str1 ="";
	static int IndicatorColumnIndex;
	static String str2 ="";
	
public static void readExcel(String filePath, String fileName, String sheet1Name) throws IOException{
	
	//create an object of File class to open xlsx file
	File file = new File(filePath + "\\" + fileName);
	
	//create an object of FileInputStream class to read excel
	
	FileInputStream inputStream = new FileInputStream(file);
	Workbook workBook = null;
	
	//find the file extension by splitting into substring
	
	String fileExtension = fileName.substring(fileName.indexOf("."));
	
	if (fileExtension.equals(".xlsx")){
		
		// If it is xlsx file then create object of XSSFWorkbook class
		
		workBook = new XSSFWorkbook(inputStream);
	}
	
	// Check condition if the file is xls file
	
	if (fileExtension.equals(".xls")){
		
		// If it is xls file then create object of HSSFWorkbook class
		
		workBook = new HSSFWorkbook(inputStream);
	}
	
	// Read sheet inside the workbook by its name
	//Credentials
	
	Sheet workSheet1 = workBook.getSheet(sheet1Name);
	
	// Find number of rows in excel file
	int RowCount1 = workSheet1.getLastRowNum() - workSheet1.getFirstRowNum();
	int columnCount1 = workSheet1.getRow(0).getPhysicalNumberOfCells();
	
	for(int i = 0; i <= columnCount1; i++){
		String columnText = workSheet1.getRow(0).getCell(i).getStringCellValue();
		if(columnText.equals("Email")){
			emailColumnIndex = i;
			break;			
		}
	}
	
	for(int i = 0; i <= columnCount1; i++){
		String columnText = workSheet1.getRow(0).getCell(i).getStringCellValue();
		if(columnText.equals("Password")){
			PasswordColumnIndex = i;
			break;			
		}
	}
	for(int i = 0; i <= columnCount1; i++){
		String columnText = workSheet1.getRow(0).getCell(i).getStringCellValue();
		if(columnText.equals("Indicator")){
			IndicatorColumnIndex = i;
			break;			
		}
	}
	// Create a loop over all the rows of excel file to read valid data
	for (int i =1; i<=RowCount1; i++){
		if(workSheet1.getRow(i).getCell(IndicatorColumnIndex).getStringCellValue().equals("Valid")){
		Row row = workSheet1.getRow(i);
		// Create a loop to print cell values in a row
		for (int j = 0; j < row.getLastCellNum(); j++) {
			DataFormatter formatter = new DataFormatter();
			String val = formatter.formatCellValue(row.getCell(j));
			str1 = str1 + (val + ";");
				}}
		if(workSheet1.getRow(i).getCell(IndicatorColumnIndex).getStringCellValue().equals("Invalid")){
		Row row = workSheet1.getRow(i);
		// Create a loop to print cell values in a row
		for (int j = 0; j < row.getLastCellNum(); j++) {
			DataFormatter formatter = new DataFormatter();
			String val = formatter.formatCellValue(row.getCell(j));
			str2 = str2 + (val + ";");
		}}
	}
	//System.out.println(str1);
	//System.out.println(str2);
}
public static String getValidEmail() throws IOException {

	return (str1.split(";"))[emailColumnIndex];

}

public static String getValidPassword() throws IOException {
	return (str1.split(";"))[PasswordColumnIndex];
}

public static String getInvalidEmail() throws IOException {

	return (str2.split(";"))[emailColumnIndex];

}

public static String getInvalidPassword() throws IOException {
	return (str2.split(";"))[PasswordColumnIndex];
}
}
