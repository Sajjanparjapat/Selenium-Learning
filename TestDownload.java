package SeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestDownload {

	public void testdownload(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		
		driver.get("https://www.sample-videos.com/download-sample-csv.php");
		Thread.sleep(2000);
		WebElement csvfile = driver.findElement(By.xpath("html/body/div[4]/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[4]/a"));
		csvfile.click();		
		Thread.sleep(5000);	
	}
}
