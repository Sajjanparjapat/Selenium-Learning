package SeleniumPackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class ScreenCapture {

	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException {

		File pathToBinary = new File("C:\\Users\\sajjankumar.parjapat\\AppData\\Local\\Mozilla Firefox\\firefox.exe");		
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile profile = new FirefoxProfile();
		driver = new FirefoxDriver(ffBinary,profile);
		driver.manage().window().maximize();
		String url1 = "https://www.google.co.in";
		String url2 = "https://www.facebook.com";
		String desnLocation = "D:\\selenuim\\" ; // User specific location where images need to store
		
		driver.get(url1);
		Thread.sleep(2000);
		ScreenCapture.takesnapShot(driver, desnLocation + "Google_home_page.png");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(".//*[@id='gbwa']/div[1]/a")).click();
		Thread.sleep(2000);
		ScreenCapture.takesnapShot(driver, desnLocation + "Google_options.bmp");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(".//*[@id='gb78']/span[1]")).click();
		Thread.sleep(2000);
		ScreenCapture.takesnapShot(driver, desnLocation + "Google_play.jpeg");
		Thread.sleep(2000);
		
		driver.get(url2);
		Thread.sleep(2000);
		ScreenCapture.takesnapShot(driver, desnLocation + "Facebook.jpg");
		Thread.sleep(2000);
		
		driver.close();
	}	
	public static void takesnapShot(WebDriver driver, String fileWithPath) throws IOException
	{
        //Convert web driver object to TakeScreenshot
		TakesScreenshot scrshot = ((TakesScreenshot)driver);
		
        //Call getScreenshotAs method to create image file
		File srcFile = scrshot.getScreenshotAs(OutputType.FILE);
		
        //Move image file to new destination
		File destinationFile = new File(fileWithPath);
		
		FileUtils.copyFile(srcFile, destinationFile);		
	}
}
