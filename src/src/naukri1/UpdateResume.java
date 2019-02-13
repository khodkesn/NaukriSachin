package naukri1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class UpdateResume {
	public static void updateResume(WebDriver driver, String Path) throws InterruptedException, AWTException{
		driver.findElement(By.xpath("//a[contains(text(), 'UPDATE PROFILE')]")).click();
		for(int i=0; i<=7; i++){
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // This  will scroll down the page by  1000 pixel vertical		
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
		}
		driver.findElement(By.xpath("//input[@class = 'fileUpload waves-effect waves-light btn-large' and @id = 'attachCV']")).click();
		
	    StringSelection s = new StringSelection(Path);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
	    Robot robot = new Robot();
	    robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
	    robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
	    robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
	    robot.keyPress(java.awt.event.KeyEvent.VK_V);
	    robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
	    Thread.sleep(3000);
	    robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);;
    }
	
}


