package amazon_shopping;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon_Driver_Page {
	
		static String URL1 = "https://www.amazon.in/";
				
		public static void main(String[] args) throws IOException, InterruptedException{
			
		System.setProperty("webdriver.chrome.driver", "C:/Users/khodk/Desktop/Drivrers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		driver.get(URL1);
		ReadExcel.readExcel("C:\\Users\\khodk\\Desktop\\Selenium Data", "Amazon Data.xlsx", "Credentials" );
		driver.manage().window().maximize();
	    Login.login(driver, "Valid");
	    YourOrders.yourOrders(driver);
	   // driver.close();
	    
	   
		
		}

	}

