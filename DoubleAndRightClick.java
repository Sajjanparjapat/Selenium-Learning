package SeleniumPackage;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

public class DoubleAndRightClick {
	
	static WebDriver driver;
	Actions builder;
	WebElement element;
	public static void main(String[] args) throws InterruptedException 
	{
		File pathToBinary = new File("C:\\Users\\sajjankumar.parjapat\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		driver = new FirefoxDriver(ffBinary,firefoxProfile);
		driver.manage().window().maximize();	
		DoubleAndRightClick ctt= new DoubleAndRightClick();
		ctt.DoubleClick();
		ctt.RightClick();
	}
	public void RightClick() throws InterruptedException 
	{
		driver.get("https://www.google.com");
		element = driver.findElement(By.xpath(".//*[@id='gbwa']/div[1]/a"));
		builder.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();	
	}
	public void DoubleClick() throws InterruptedException 
	{
		driver.get("http://api.jquery.com/dblclick/");
		driver.switchTo().frame(0);
		builder = new Actions(driver);
		element = driver.findElement(By.xpath("html/body/div[1]"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", element);
		Thread.sleep(2000);
		builder.doubleClick(element).build().perform();
	}
}
