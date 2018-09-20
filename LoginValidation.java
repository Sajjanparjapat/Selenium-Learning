package SeleniumPackage;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginValidation {
WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		LoginValidation lv=new LoginValidation();
		lv.setup();
		lv.testLogin();
	}
	public void setup()
	{
		File pathToBinary = new File("C:\\Users\\Vikas\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		driver = new FirefoxDriver(ffBinary,firefoxProfile);
		driver.manage().window().maximize();
	}
	public void testLogin() throws InterruptedException
	{
		String Url = "https://viewer-dev.leverton.ai/login/auth";
		driver.get(Url);
		WebElement Username = driver.findElement(By.id("username"));
		WebElement Password = driver.findElement(By.id("password-field"));
		Username.sendKeys("InvalidUserName");
		Password.sendKeys("InvalidPassword");
		WebElement LoginButton = driver.findElement(By.xpath("//*[@id='loginForm']/div[4]/input"));
		LoginButton.click();
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,5) ;
		WebElement ErrMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='loginForm']/div[1]/p[2]")));
		if(ErrMsg.isDisplayed())
		{		
			System.out.println("Login Failed : " + ErrMsg.getText());
		}
		else {
			System.out.println("Login Successully");
		}
		driver.close();
	}

}
