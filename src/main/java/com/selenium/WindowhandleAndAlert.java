package com.selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowhandleAndAlert{

	public static void main(String[] args) throws InterruptedException {
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
		
		//Handle windows1
		
		driver.findElement(By.xpath("//span[text()='From Lead']/../following-sibling::td/a/img")).click();
		Set<String> allWindows = driver.getWindowHandles();
		List<String> allList = new ArrayList();
		allList.addAll(allWindows);
		driver.switchTo().window(allList.get(1));
		System.out.println(driver.getTitle());
		
		//Typing the first lead id
		
		driver.findElement(By.name("id")).sendKeys("17106");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//a[text()='17106']")).click();
		
		//Handle windows2
		driver.switchTo().window(allList.get(0));
		System.out.println(driver.getTitle());
		
		
		driver.findElement(By.xpath("//span[text()='To Lead']/../following-sibling::td/a/img")).click();
		Set<String> allWindows1 = driver.getWindowHandles();
		List<String> allList1 = new ArrayList();
		allList1.addAll(allWindows1);
		driver.switchTo().window(allList1.get(1));
		System.out.println(driver.getTitle());
		
		//Typing the second lead id
		
		driver.findElement(By.name("id")).sendKeys("17108");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//a[text()='17108']")).click();
		driver.switchTo().window(allList1.get(0));
		
		//Handle javaScript Alert
		driver.findElement(By.linkText("Merge")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	}

}
