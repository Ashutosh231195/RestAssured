package utiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class excelData {
	static FileInputStream file;
static	Workbook b;
	static Sheet s;
	Object[][] 	obj;
	public static Object[][] readdata(String sheetName) throws FileNotFoundException {
		String path=System.getProperty("user.dir");
		file = new FileInputStream("C:\\Users\\Aashuu\\eclipse-workspace\\RestAssurd\\ExcelFile\\testdata1.xlsx");
		try {
		b=	WorkbookFactory.create(file);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	s=	b.getSheet( sheetName);
	int rowcount =s.getLastRowNum();
	int cellcount=s.getRow(0).getPhysicalNumberOfCells();
	Object[][]data= new Object[rowcount ][cellcount];
	for (int i=0;i<rowcount;i++) {
		for (int j=0;j<cellcount;j++){
			data[i][j]=s.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
	return data;
	}
	@DataProvider
	public Object[][] data() throws EncryptedDocumentException, IOException{

try {
	obj = excelData.readdata("newtest");
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return obj;
		
	}
@Test(dataProvider="data")
public void test(String userName, String password,String sex) {
	System.out.println(userName);
	System.out.println(password);

	System.out.println(sex);
}
}
