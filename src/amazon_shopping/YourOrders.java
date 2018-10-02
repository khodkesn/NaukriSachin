package amazon_shopping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class YourOrders {
	
public static void yourOrders(WebDriver driver) throws InterruptedException{
	
	Actions obj = new Actions(driver);
	obj.moveToElement(driver.findElement(By.xpath("//span[contains(text(), 'Your Orders') and @class='nav-line-2']"))).build().perform();
	obj.moveToElement(driver.findElement(By.xpath("//span[contains(text(), 'Your Orders') and @class = 'nav-text']"))).click().build().perform();
	driver.findElement(By.xpath("//span[@class = 'a-button-text a-declarative']")).click();
	obj.moveToElement(driver.findElement(By.xpath("//a[@class = 'a-dropdown-link' and contains(text(), '2017')]"))).click().build().perform();
	//Thread.sleep(1000);
	driver.findElement(By.xpath("//span[contains(text(), '20 January 2017')]")).isDisplayed();

	
	
}
}

