package demo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExceldataRead {
	
	@DataProvider
public Object[][] ExcelReadData() throws EncryptedDocumentException, IOException {
		
		
		FileInputStream file=new FileInputStream("C:\\Users\\Aashuu\\OneDrive\\Documents\\testdata1.xlsx");
	Workbook wb=	WorkbookFactory.create(file);
	     org.apache.poi.ss.usermodel.Sheet sheet=    wb.getSheet("newtest");
	  int rowCount=   sheet.getLastRowNum();
	 int cellCount= sheet.getRow(0).getPhysicalNumberOfCells();
	 Object data[][]= new Object [rowCount][cellCount];
	 
	 for (int i=0;i<rowCount;i++) {
		 for(int j=0;j<cellCount;j++) {
			 
		 
		data[i][j]= sheet.getRow(i+1).getCell(j).getStringCellValue(); 
		 }	 
	 }
	 return data;
	}

@Test(dataProvider="ExcelReadData")
public void readdata(String userName, String password) {
System.out.println(userName);
System.out.println(password);
System.out.println(Thread.currentThread().getId());
}


@Test(invocationCount=3,dependsOnMethods="readdata",timeOut=2)
public void demo() {
	System.out.println("demo"+Thread.currentThread().getId());
}
	
}
