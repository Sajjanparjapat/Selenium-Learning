package SeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestUpload 
{	
	public void uploadimage(WebDriver driver) throws InterruptedException
	{
		driver.get("http://demo.guru99.com/test/upload/");
		WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));
		uploadElement.sendKeys("D:\\Selenuim\\Selenium.txt");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("submitbutton")).click();
		System.out.print("File Upload Successfully.");
		Thread.sleep(000);	
	}
}
