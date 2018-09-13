package SeleniumPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class ExcelUtils {
	
	public final static String Path_TestData = "D:\\selenuim\\"; //Place your Excel File location here
	public final static String File_TestData = "TestData.xls"; //Place your excel name Extension should be .xls
	public static HSSFSheet ExcelWSheet;
	public static HSSFWorkbook ExcelWBook;
	public HSSFCell Cell;
	public HSSFRow Row;
	static FileInputStream ExcelFile;
	static FileOutputStream fileOut;
	public static WebDriver driver;
	static String Username, pwd, UserType;
	public String Result;
	int i,j;
	static ExcelUtils ex;
	WebElement AcExist;
	public static void main(String[] args) throws Exception
	{
		ex = new ExcelUtils();
		//Browser Compatibility setting
		File pathToBinary = new File("C:\\Users\\sajjankumar.parjapat\\AppData\\Local\\Mozilla Firefox\\firefox.exe");		
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile profile = new FirefoxProfile();
		driver = new FirefoxDriver(ffBinary,profile);
		
		driver.manage().window().maximize();
		String url = "https://www.gmail.com";
		driver.get(url);
		ex.setExcelFile(Path_TestData, File_TestData);
		ex.Test();		
		driver.close();
		FileOutputStream fileOut = new FileOutputStream(Path_TestData+File_TestData);
		ExcelWBook.write(fileOut);
		ExcelWBook.close();
		fileOut.flush();
		fileOut.close();
	}
	
	public void Test() throws Exception
	{
		for (i=1,j=0; i<=ExcelWSheet.getLastRowNum(); i++)
		{			
			Username = ex.getCellData(i,j);
			pwd = ex.getCellData(i,j+1);
			UserType = ex.getCellData(i, j+2);
			System.out.println(Username + " : " + pwd +" : " + " : "+ UserType);
			String TC_Result = ex.Login(Result);
			ex.SetCellData(TC_Result,i,j+3);
		}
	}
	
	public void setExcelFile(String path, String SheetName) throws Exception
	{
		try
		{
			ExcelFile = new FileInputStream(path+SheetName);
			ExcelWBook = new HSSFWorkbook(ExcelFile);	
			ExcelWSheet = ExcelWBook.getSheet(ExcelWBook.getSheetName(0));	

		}
		catch (Exception e) {
			throw (e);
		}
	}
	
	public String getCellData(int RowNum, int ColNum) throws Exception
	{
		try
		{
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData; 
		}
		catch (Exception e) {
			throw (e);
		}
	}
	
	public void SetCellData (String Result, int RowNum, int ColNum) throws Exception
	{
		try {
					
			Row = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum);
			if (Cell==null)
			{
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
				System.out.println(Result);
			} else
			{
				Cell.setCellValue(Result);
			}
		}
		catch (Exception e) {
			throw (e);
		}
	}
	
	public String Login (String Result)throws Exception
	{
		try
		{
		driver.findElement(By.id("Email")).sendKeys(Username);
		Thread.sleep(2000);
		driver.findElement(By.id("next")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Passwd")).sendKeys(pwd);
		Thread.sleep(2000);
		driver.findElement(By.id("signIn")).click();
		Thread.sleep(5000);
		WebElement signOut = driver.findElement(By.xpath(".//*[@id='gb_71']"));
		
		if(signOut.isDisplayed())
			Result = "TC_Passed";
		else
			Result = "TC_Failed";
		
		signOut.click();
		Thread.sleep(2000);
		if (AcExist == null)
		{
			AcExist = driver.findElement(By.id("account-chooser-link"));
			AcExist.click();
		}
		driver.findElement(By.id("account-chooser-add-account")).click();
		return Result;
		}
		catch(Exception e)
		{
			Result = "TC_Failed";
			return Result;
		}
	}
}