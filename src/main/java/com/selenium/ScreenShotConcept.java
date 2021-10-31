package com.selenium;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotConcept {
	
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver",
				"./chromedriver.exe");

	    driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://leaftaps.com/opentaps");
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		/*ScreenShotConcept.getScreenshot();*/
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();


	}
	
	public static String getScreenshot(WebDriver driver,String name) throws IOException {
		String date = new SimpleDateFormat("mmddyyyhhmss").format(new Date());
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination="./Screenshot/\"+date+name+\".png";
		File desc =new File(destination);
		FileUtils.copyFile(src, desc);
		return destination;
		
	}
	

}
