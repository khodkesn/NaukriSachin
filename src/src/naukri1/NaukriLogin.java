package naukri1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NaukriLogin {
	
	public static void naukriLogin(WebDriver driver, String UserName, String Password) throws InterruptedException{
	
			driver.findElement(By.xpath("//div[@class = 'mTxt' and contains(text(), 'Login')]")).click();
			
			driver.findElement(By.xpath("//input[@id = 'eLoginNew']")).sendKeys(UserName);
			driver.findElement(By.xpath("//input[@id = 'pLogin']")).sendKeys(Password);
			driver.findElement(By.xpath("//button[@value = 'Login']")).click();
			Thread.sleep(2000);
		}
}

