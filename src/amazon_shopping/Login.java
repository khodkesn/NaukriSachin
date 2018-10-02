package amazon_shopping;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	public static void login(WebDriver driver, String Ind) throws IOException{
		if (Ind.equals("Valid")){
		String email = ReadExcel.getValidEmail();
		String Password = ReadExcel.getValidPassword();
		driver.findElement(By.xpath("//span[contains(text(), 'Hello. Sign in')]")).click();
		CommonFunctions.waitForElement(driver, By.xpath("//input[@type='email']")).sendKeys(email);
		System.out.println(email);
	    driver.findElement(By.xpath("//input[@id ='continue']")).click();
	    driver.findElement(By.xpath("//input[@type ='password']")).sendKeys(Password);
	    driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		}
		
		if (Ind.equals("Invalid")){
			try{
			String email = ReadExcel.getInvalidEmail();
			String Password = ReadExcel.getInvalidPassword();
			driver.findElement(By.xpath("//span[contains(text(), 'Hello. Sign in')]")).click();
			CommonFunctions.waitForElement(driver, By.xpath("//input[@type='email']")).sendKeys(email);
		    driver.findElement(By.xpath("//input[@id ='continue']")).click();
		    driver.findElement(By.xpath("//input[@type ='password']")).sendKeys(Password);
		    driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
			}
			catch (Exception e){
				driver.findElement(By.xpath("//h4[contains(text(), 'There was a problem')]")).isDisplayed();
			}
			}
		
}
}