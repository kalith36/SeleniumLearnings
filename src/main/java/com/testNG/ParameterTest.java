package com.testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {

	WebDriver driver;


	@Parameters({"url","Uname","Password"})
	@Test
	public void crmLoginTest(String URL,String username,String pwd) {

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

		driver=new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);

		//Login
		driver.findElement(By.name("USERNAME")).sendKeys(username);
		driver.findElement(By.name("PASSWORD")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.quit();


	}

}
