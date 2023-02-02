package qaautomation.jlabs;


import org.testng.annotations.Test;

import qaautomation.jlabs.LoginPage;
import qaautomation.jlabs.ProfilePage;
import qaautomation.jlabs.ObjectRepository;
import qaautomation.jlabs.BasedWebTest;
import qaautomation.jlabs.BasePage;

public class WebTestEmail extends BasedWebTest {
	
	ObjectRepository obj = new ObjectRepository();
	LoginPage loginPage = new LoginPage(driver, explicitWait);
	ProfilePage profilePage = new ProfilePage(driver, explicitWait);

	@Test
	public void loginTest() {
		loginPage.inputEmail(obj.userEmail());
		loginPage.loginEmail();
		


	/**
	* To Get Element inside Iframe, switch to Iframe First.
	*
	*/
		profilePage.switchToIframe(obj.firstIframe());
		loginPage.clickAndWait(obj.indexEmail1());
		profilePage.switchToIframe(null);

	}

}
