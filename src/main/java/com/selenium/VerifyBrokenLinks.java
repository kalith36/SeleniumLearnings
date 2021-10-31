package com.selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyBrokenLinks {
	WebDriver driver;

	@Test
	public void verifyLinks() throws MalformedURLException, IOException {
		
		//SetUP the browser

		System.setProperty("webdriver.chrome.driver","./chromedriver_new.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Login to freCRM
		driver.get("https://jqueryui.com/");
		

		//1.Get all the links(a/img tag)

		List<WebElement> linkList = driver.findElements(By.xpath("//aa"));
		System.out.println("The total anchor tag links are :"+linkList.size());
		
		
		
		linkList.addAll(driver.findElements(By.tagName("img")));
		System.out.println("The total links:"+linkList.size());

		//2.Get the active links using href attribute

		List<WebElement> activeLinks = new ArrayList<WebElement>();
		//iterate and exclude the link which dont have href property


			for (int i = 0; i < linkList.size(); i++) {
				if (linkList.get(i).getAttribute("href") !=null || linkList.get(i).getAttribute("src") !=null ){
					activeLinks.add(linkList.get(i));
				}

			}
		//get the size of active links alone
		System.out.println("The active links are:"+activeLinks.size());
		
		//3.check the URL with httpConnection api:
		
		for (int j = 0; j < activeLinks.size(); j++) {
			
			HttpURLConnection connection=(HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String responseMessage = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href") +"---->"+responseMessage);
		}
		 
}	
	}
