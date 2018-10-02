package amazon_shopping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CommonFunctions {
	public static WebElement waitForElement(WebDriver driver, By elem){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement foo = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='email']")));
		return foo;
		
	}
	}


