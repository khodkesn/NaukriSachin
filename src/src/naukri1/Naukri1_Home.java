package naukri1;


import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Naukri1_Home {
	// String URL3 = ;
	
	public static void main(String[] args) throws InterruptedException, AWTException{
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/khodk/Desktop/Drivrers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//String URL = ;
		driver.get("https://www.naukri.com");
		driver.manage().window().maximize();
		NaukriLogin.naukriLogin(driver, "khodkesn@gmail.com", "Sk@830296");
		UpdateResume.updateResume(driver, "C:\\Users\\khodk\\Desktop\\Work and study\\Resume\\Sachin_Khodke_Resume.doc");
		Thread.sleep(3000);
		driver.quit();;
}}
