package qaautomation.jlabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

import qaautomation.jlabs.ObjectRepository;


public class BasedWebTest {
	public ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();
	ObjectRepository obj = new ObjectRepository();
	

	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver());
		driver.get().manage().window().maximize();
		explicitWait.set(new WebDriverWait(driver.get(), 600));
		driver.get().get(obj.urlPortal());
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.get().quit();
	}

}
