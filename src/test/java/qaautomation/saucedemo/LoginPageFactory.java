package qaautomation.saucedemo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageFactory extends BasePageFactory{
	
	@FindBy(id = "user-name")
	private WebElement username;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(xpath = "//*[@id=\"login-button\"]")
	private WebElement loginBtn;
	
	
	public LoginPageFactory(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
		PageFactory.initElements(driver.get(), this);
	}
	
	public void inputUsername(String usernameInput) {
		username.sendKeys(usernameInput);
	}
	
	public void inputPassword(String passwordInput) {
		password.sendKeys(passwordInput);
	}
	
	public void loginBtn() {
		loginBtn.click();
	}
}
