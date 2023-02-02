package qaautomation.saucedemo;

import org.testng.Assert;
import org.testng.annotations.Test;

import qaautomation.saucedemo.LoginPageFactory;
import qaautomation.saucedemo.ProfilePageFactory;

import org.openqa.selenium.By;


public class WebTestUsingPageFactory extends BasedWebTest  {
	
	String username = "standard_user";
	String password = "secret_sauce";
	
	//1
	@Test
	public void testLogin() throws InterruptedException {
		LoginPageFactory loginPage = new LoginPageFactory(driver, explicitWait);
		ProfilePageFactory profilePage = new ProfilePageFactory(driver, explicitWait);
		//loginpage
		loginPage.inputUsername(username);
		loginPage.inputPassword(password);
		loginPage.loginBtn();
		driver.get().findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		driver.get().findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		driver.get().findElement(By.xpath("//*[@id=\"checkout\"]")).click();
		driver.get().findElement(By.id("first-name")).sendKeys("Muhammad");
		driver.get().findElement(By.id("last-name")).sendKeys("Arief");
		driver.get().findElement(By.id("postal-code")).sendKeys("17121");
		driver.get().findElement(By.xpath("//*[@id=\"continue\"]")).click();
		driver.get().findElement(By.xpath("//*[@id=\"finish\"]")).click();
		driver.get().findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
		driver.get().findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
		
		
		
		
		//profilpage
		String actualText = profilePage.getProfileText();
		System.out.println("actual"+actualText);
		
	}

	@Test
	public void testWrongUsername() { 
	driver.get().findElement(By.id("user-name")).sendKeys("standard_user1");
	driver.get().findElement(By.name("password")).sendKeys("secret_sauce");
	driver.get().findElement(By.xpath("//input[@id='login-button']")).click();
	String actualText = driver.get().findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
	String expectedText = "Epic sadface: Username and password do not match any user in this service";
	System.out.println("actual"+actualText);
	System.out.println("expected"+expectedText);
	Assert.assertTrue(actualText.contains(expectedText));
	
	}
	
	@Test
	public void testWrongPassword() {
	driver.get().findElement(By.id("user-name")).sendKeys("standard_user");
	driver.get().findElement(By.name("password")).sendKeys("secret_sauce!");
	driver.get().findElement(By.xpath("//input[@id='login-button']")).click();
	String actualText = driver.get().findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
	String expectedText = "Epic sadface: Username and password do not match any user in this service";
	System.out.println("actual"+actualText);
	System.out.println("expected"+expectedText);
	Assert.assertTrue(actualText.contains(expectedText));
	
	}
}

	
