package SeleniumPackage;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionEx {
		static WebDriver driver;
		WebElement From, To,ScrollDown;
		String Element;
		Actions builder;
		Action DragnDrop;
	
	public static void main(String[] args) throws InterruptedException {

		File pathToBinary = new File("C:\\Users\\sajjankumar.parjapat\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		driver = new FirefoxDriver(ffBinary,firefoxProfile);
		driver.manage().window().maximize();
		ActionEx Ex = new ActionEx();
		Ex.folderDragandDrop();
		Ex.dragAndDrop();
		Ex.imgDropandDrop();
		Ex.dragAndDrop();
		driver.close();
	}
	public void folderDragandDrop()
	{
		String URL = "https://dhtmlx.com/docs/products/dhtmlxTree/";
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		From = driver.findElement(By.xpath(".//*[@id='treebox1']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[4]/td[2]/table/tbody/tr[1]/td[4]/span"));
		To = driver.findElement(By.xpath(".//*[@id='treebox2']/div/table/tbody/tr[3]/td[2]/table/tbody/tr[1]/td[4]/span"));
		ScrollDown = driver.findElement(By.id("live-demo"));
		Element = "Folder";
	}
	
	public void imgDropandDrop()
	{
		String URL = "https://www.w3schools.com/html/tryit.asp?filename=tryhtml5_draganddrop";
		String Nwindow = driver.getWindowHandle();
		From.sendKeys(Keys.CONTROL+"t");
		driver.switchTo().window(Nwindow);
		driver.get(URL);
		driver.switchTo().frame(driver.findElement(By.name("iframeResult")));
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		From = driver.findElement(By.id("drag1"));
		To = driver.findElement(By.id("div1"));
		Element = "W3School Logo";
	}
	
	public void dragAndDrop() throws InterruptedException
	{
		try {
			builder = new Actions(driver);
			if(Element == "Folder") {
				builder.moveToElement(ScrollDown);
			}
			//DragnDrop = builder.moveToElement(From).pause(1).clickAndHold(From).pause(1).moveToElement(To).pause(1).release(To).pause(1).build();
			DragnDrop = builder.clickAndHold(From).moveToElement(To).release(To).build();
			Thread.sleep(2000);
			DragnDrop.perform();
			System.out.println(Element + " Drag and Drop Completed Successfully.");
			Thread.sleep(2000);
			}
		catch (Exception e)
		{
			e.getMessage();
		}
	}
}