package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyErrorMergeLead {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"./chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://leaftaps.com/crmsfa/control/mergeLeadsForm");
		//Login
		driver.findElement(By.name("USERNAME")).sendKeys("DemoSalesmanager");
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//Input the lead id in fields
		
		driver.findElement(By.xpath("//span[text()='From Lead']/../following-sibling::td/table//td/input")).sendKeys("17106");
		driver.findElement(By.xpath("//span[text()='To Lead']/../following-sibling::td/table//td/input")).sendKeys("17108");
		driver.findElement(By.linkText("Merge")).click();
		
		//Handle Alerts
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		//Verify Error Message
		WebElement mergeError1 = driver.findElement(By.xpath("//div[@class='messages']/div"));
		String error1 = mergeError1.getText();
		System.out.println(error1);
		
		WebElement mergeError2 = driver.findElement(By.xpath("//div[@class='messages']/child::ul/li"));
		String error2 = mergeError2.getText();
		System.out.println(error2);
		
		String windowHandle = driver.getWindowHandle();
		
		
		driver.quit();
		
		

	}

}
