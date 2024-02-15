package Utils;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Date;
	import java.util.Random;

	import org.apache.poi.EncryptedDocumentException;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.io.FileHandler;

	public class Utility { 
		public static void captureScreenshot(WebDriver driver,String testID) throws IOException {			
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			Date date=new Date();
			String FileName = date.toString().replace(" ","_").replace(":", " ") ;
			File dest= new File("test-output\\FailedScreeshots\\Test"+testID+" "+FileName+".jpg");
			FileHandler.copy(src,dest );			
		}
		
		public static String fetchDataFromExcelSheet(String sheet,int row, int column) throws EncryptedDocumentException, IOException {
			String path= "src/main/resources/data/testdata.xlsx"; 
			FileInputStream file= new FileInputStream(path);
			String data = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(column).getStringCellValue();
			return data;
		}	
			

}
