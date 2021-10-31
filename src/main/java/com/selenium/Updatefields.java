package com.selenium;

import java.awt.image.TileObserver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Updatefields {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Ahamed Razik/Downloads/chromedriver_win32/chromedriver_new.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://leaftaps.com/opentaps");
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.xpath("//div[@id='button']/child::a/img")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		String title2 = driver.getTitle();
		System.out.println(title2);
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("CG");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("mohd");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("kalith");
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		
		
		
		
		
	}

}
