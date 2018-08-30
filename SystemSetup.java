package SeleniumPackage;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class SystemSetup {

	public static WebDriver driver;
	public static FirefoxProfile profile;
	public static void main(String[] args) throws InterruptedException 
	{
		SystemSetup ss = new SystemSetup();
		ss.LoadFirefox();
		
		//Uploading File..,
		//TestUpload tp= new TestUpload();
		//tp.uploadimage(driver);
		
		//Downloading File.., 
		TestDownload td=new TestDownload();
		td.testdownload(driver);
		
		driver.close();
	}
	
	public void LoadFirefox() {
		
		File pathToBinary = new File("C:\\Users\\sajjankumar.parjapat\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList",2);
		profile.setPreference("browser.download.manager.showWhenStarting",false);
		profile.setPreference("browser.download.dir","D:\\Selenuim");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/csv");
		driver = new FirefoxDriver(ffBinary,profile);
		driver.manage().window().maximize();
	}
}