package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver",
				"./chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://leaftaps.com/crmsfa/control/createLeadForm");
		//Login
		driver.findElement(By.name("USERNAME")).sendKeys("DemoSalesmanager");
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		//Handle Dropdown
		
		WebElement source = driver.findElement(By.id("createLeadForm_dataSourceId"));
		
		Select se =new Select(source);
		se.selectByVisibleText("Employee");
		

	}

}
