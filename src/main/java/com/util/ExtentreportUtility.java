package com.util;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.selenium.ScreenShotConcept;

public class ExtentreportUtility extends ScreenShotConcept{


	//public static WebDriver driver;
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports extentReports;
	public static ExtentTest test, node;

	@BeforeTest
	public void setExtent() {
		htmlreporter= new ExtentHtmlReporter("./Reports/extent.html");

		htmlreporter.config().setDocumentTitle("AutomationReport");
		htmlreporter.config().setReportName("FunctionalTesting");
		htmlreporter.config().setTheme(Theme.STANDARD);

		extentReports=new ExtentReports();
		extentReports.attachReporter(htmlreporter);
		extentReports.setSystemInfo("Environment", "QA");
		extentReports.setSystemInfo("TesterName", "MohamedKalith");
		extentReports.setSystemInfo("BrowserName", "Chrome");
		extentReports.setSystemInfo("OS", "Windows");
	}


	@AfterTest
	public void endReport() {
		extentReports.flush();
	}


	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./chromedriver_new.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("http://leaftaps.com/opentaps");
		
		
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL,"Testcase Failed is:"+ result.getName());
			test.log(Status.FAIL, "Testcase Failed is:"+ result.getThrowable());
			
			String screenshotPath = ScreenShotConcept.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
		}else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "Testcase Skipped is:"+result.getName());
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "Testcase Skipped is:"+result.getName());

		}
		driver.quit();
	}


	
}
