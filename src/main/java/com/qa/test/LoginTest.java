package com.qa.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.util.ExtentreportUtility;

public class LoginTest extends ExtentreportUtility{
	
	@Test(priority=1)
	public void loginTest()
	{
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");;
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	@Test(priority=0)
	public void loginPageTitleTest() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Leaftaps - TestLeaf Automation Platform");
	}
	
	@Test(priority=2)
	public void homepageTitleTest() {
		String homeTitle = driver.getTitle();
		Assert.assertEquals(homeTitle, "Homepage");
	}

}
