package com.seleniumInterviewQuestions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SizeAndLocationOfWebElement {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver(); 

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		driver.get("https://opensource-demo.orangehrmlive.com/");

		WebElement logo=driver.findElement(By.xpath("//div[@id='divLogo']/img"));

		//Location-method 1
		System.out.println("Location of (x,y) :"+logo.getLocation());
		System.out.println("Location of X :"+logo.getLocation().getX());
		System.out.println("Location of Y :"+logo.getLocation().getY());

		//Location-method 2
		
		System.out.println("Location of X :"+logo.getRect().getX());
		System.out.println("Location of Y :"+logo.getRect().getY());

		//Size -Method 1
		System.out.println("Size of (Width,Height) :"+logo.getSize());
		System.out.println("Size of Width :"+logo.getSize());
		System.out.println("Size of Height :"+logo.getSize());

		//Size -Method 1
		System.out.println("Size of (Width,Height) :"+logo.getRect().getDimension());
		System.out.println("Size of Width :"+logo.getRect().getDimension().getHeight());
		System.out.println("Size of Height :"+logo.getRect().getDimension().getWidth());
		System.out.println("Size of Width :"+logo.getRect().getHeight());
		System.out.println("Size of Height :"+logo.getRect().getWidth());

	}

}
