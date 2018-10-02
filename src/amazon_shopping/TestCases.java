package amazon_shopping;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

//import org.apache.tools.ant.util.FileUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


//import com.mongodb.MapReduceCommand.OutputType;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestCases {

	WebDriver driver = null;
	static String URL = "https://www.amazon.in/";

	ExtentReports extent;
	ExtentTest logger;

	@BeforeTest
	public void startReport() {

		System.out.println(System.getProperty("user.dir"));

		// ExtentReports(String filePath,Boolean replaceExisting)
		// filepath - path of the file, in .htm or .html format - path where
		// your report needs to generate.
		// replaceExisting - Setting to overwrite (TRUE) the existing file or
		// append to it
		// True (default): the file will be replaced with brand new markup, and
		// all existing data will be lost. Use this option to create a brand new
		// report
		// False: existing data will remain, new tests will be appended to the
		// existing report. If the the supplied path does not exist, a new file
		// will be created.
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/STMExtentReport.html", true);
		// extent.addSystemInfo("Environment","Environment Name")
		extent.addSystemInfo("Environment", "Automation Testing").addSystemInfo("User Name", "Sachin Khodke");
		// loading the external xml file (i.e., extent-config.xml) which was
		// placed under the base directory
		// You could find the xml file below. Create xml file in your project
		// and copy past the code mentioned below
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
	}

	@BeforeMethod
	public void before(Method mthod) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/khodk/Desktop/Drivrers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		ReadExcel.readExcel("C:\\Users\\khodk\\Desktop\\Selenium Data", "Amazon Data.xlsx", "Credentials");
		logger = extent.startTest(mthod.getName());
	}

	@Test
	// login with Valid Credentilas
	public void Test1() throws Exception {
		/*
		 * driver.get(URL); driver.manage().window().maximize();
		 * ReadExcel.readExcel("C:\\Users\\khodk\\Desktop\\Selenium Data",
		 * "Amazon Data.xlsx", "Credentials" );
		 */		
		try {
			Login.login(driver, "Valid");
			String img = logger.addScreenCapture("C://Users//khodk//Desktop//Selenium Data//Screenshots//Test1.png");
			logger.log(LogStatus.PASS, "Test Case Status is passed", img);
		} catch (IOException e) {
			logger.log(LogStatus.PASS, "Test Case Status is failed");
			e.printStackTrace();
		}
		
		driver.close();
	}

	@Test
	public void Test2() {
		// login with Invalid Credentilas
		/*
		 * driver = new ChromeDriver(); driver.get(URL);
		 * driver.manage().window().maximize();
		 */
		try {
			Login.login(driver, "Invalid");
			logger.log(LogStatus.PASS, "Test Case Status is passed");
		} catch (IOException e) {
			logger.log(LogStatus.PASS, "Test Case Status is failed");
			e.printStackTrace();

		}
		driver.close();
	}

	@Test(dependsOnMethods = "Test1")
	public void Test3() {
		// Check your orders
		/*
		 * driver = new ChromeDriver(); driver.get(URL);
		 * ReadExcel.readExcel("C:\\Users\\khodk\\Desktop\\Selenium Data",
		 * "Amazon Data.xlsx", "Credentials" );
		 * driver.manage().window().maximize();
		 */
		try {
			Login.login(driver, "Valid");
			YourOrders.yourOrders(driver);
			logger.log(LogStatus.PASS, "Test Case Status is passed");
		} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.PASS, "Test Case Status is failed");
		}
		driver.close();

	}

	@AfterTest
	public void endReport() {
		// writing everything to document
		// flush() - to write or update test information to your report.
		extent.flush();
		// Call close() at the very end of your session to clear all resources.
		// If any of your test ended abruptly causing any side-affects (not all
		// logs sent to ExtentReports, information missing), this method will
		// ensure that the test is still appended to the report with a warning
		// message.
		// You should call close() only once, at the very end (in @AfterSuite
		// for example) as it closes the underlying stream.
		// Once this method is called, calling any Extent method will throw an
		// error.
		// close() - To close all the operation
		// extent.close();
	}

	

}
