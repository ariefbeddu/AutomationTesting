package qaautomation.jlabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import qaautomation.jlabs.BasePage;

public class LoginPage extends BasePage{
	By emailId = By.id("login");
	By loginEmail = By.xpath("//*[@id=\"refreshbut\"]/button/i");
	By newEmail = By.xpath("//*[@id=\"newmail\"]/i");


	public LoginPage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
	}
	
	public void inputEmail(String emailInput) {
		setText(emailId, emailInput);
	}
	public void loginEmail() {
		clickAndWait(loginEmail);
	}
	public void newEmail() {
		clickAndWait(newEmail);
	}


	}
	
