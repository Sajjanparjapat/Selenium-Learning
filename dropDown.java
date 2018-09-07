package SeleniumPackage;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

public class dropDown {

	public static void main(String[] args) throws InterruptedException {

		File pathToBinary = new File("C:\\Users\\sajjankumar.parjapat\\AppData\\Local\\Mozilla Firefox\\firefox.exe");		
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile profile = new FirefoxProfile();
		FirefoxDriver driver = new FirefoxDriver(ffBinary,profile);
		driver.manage().window().maximize();
		
		String url = "https://www.facebook.com";
		driver.get(url);
		//finding month element 
		WebElement month = driver.findElement(By.id("month"));
		Select myselection = new Select(month);
		//Creating list and storing all element into List from drop down
		List<WebElement> element = myselection.getOptions();
		
		//Displaying including Month text
		for (int i=0;i<element.size();i++)
		{
			//Printing iterator and month of the drop down
			System.out.println(i +". "+ element.get(i).getText());
			//Traverse though month drop down using list 
			month.sendKeys(element.get(i).getText());
			Thread.sleep(2000);
		}
		
		System.out.println("__ Displaying from the First Month__");
		
		for (int i=1;i<element.size();i++)
		{
			System.out.println(i +". "+ element.get(i).getText());
			month.sendKeys(element.get(i).getText());
			Thread.sleep(2000);
		}
		driver.close();		
	}
}
