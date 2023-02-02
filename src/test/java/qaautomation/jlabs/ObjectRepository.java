package qaautomation.jlabs;

import org.openqa.selenium.By;

public class ObjectRepository {
		/**
		 * Define Object Element Path
		 *
		 */
		By iFieldEmail = By.id("login");
		By btnLogin = By.id("refreshbut");
		By indexEmail1 = By.xpath("//*[@id=\"mail\"]");
		By ProfileText = By.id("webmail");
		String firstIframe = "ifmail";
		
		String urlPortal = "https://yopmail.com/";
		String userEmail = "tes@gmail.com";

		public By iFieldEmail() {
			return iFieldEmail;
		}
		

		public By btnLogin() {
			return btnLogin;
		}

		public By indexEmail1() {
			return indexEmail1;
		}

		public String firstIframe() {
			return firstIframe;
		}


		public String urlPortal() {
			return urlPortal;
		}

		public String userEmail() {
			return userEmail;
		}

	}


