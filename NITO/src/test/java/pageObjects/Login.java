package pageObjects;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import applicationUtilities.ApplicationUtilities;
import generalUtilities.ReadProperties;

public class Login {

	WebDriver driver;
	ApplicationUtilities appUts;
	ReadProperties readprop;

	public Login(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		appUts = new ApplicationUtilities(driver);
		readprop = new ReadProperties("testData/TestData.properties");

	}

	@BeforeMethod
	public void beforeLoginToApplication() {
		// driver.findElement(By.id("loginText")).click();
		// driver.manage().window().maximize();
	}

	public void loginToApplication() {
		System.out.println(" Start PO : loginToApplication");
		System.out.println("loginToApplication");

		appUts.returnAnElement("id", "username").sendKeys("Admin1");
		appUts.returnAnElement("id", "password").sendKeys("electus999");
		appUts.returnAnElement("xpath", "//button[text()='Sign In']").click();

		System.out.println(" End PO : loginToApplication");
	}

	public void switchWindow() {
		System.out.println(" Start PO : switchWindow");
		System.out.println("switchWindow");
		//String mulWindow = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		//driver.switchTo().window(mulWindow);

		System.out.println(" End PO : switchWindow");
	}

	public void logoutFromApplication() {
		System.out.println(" Start PO : logoutFromApplication");
		System.out.println("logoutFromApplication");

		appUts.returnAnElement("xpath", "//a[@class='a ng-star-inserted']//span[contains(text(),'Logout')]").click();
		System.out.println(" End PO : logoutFromApplication");

	}

}
