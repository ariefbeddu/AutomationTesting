package qaautomation.jlabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import qaautomation.jlabs.BasePage;

public class ProfilePage extends BasePage {

	public ProfilePage(ThreadLocal<WebDriver> driver, ThreadLocal<WebDriverWait> explicitWait) {
		super(driver, explicitWait);
	}

	public String getProfileText(By profileText) {
		return getText(profileText);
	}

	public void switchToIframe1(String iFrame){
		driver.get().switchTo().frame(iFrame);
	}

	public void switchToParentFrame(){
		driver.get().switchTo().parentFrame();
	}

	public void switchToIframe(String iFrame){
		if (iFrame != null){
			driver.get().switchTo().frame(iFrame);
		} else {
			driver.get().switchTo().parentFrame();
		}
	}
}
