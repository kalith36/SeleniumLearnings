package com.seleniumInterviewQuestions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GettheCSSValue {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		//WebDriver driver = new ChromeDriver(); 
		
		RemoteWebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.monsterindia.com/");
		
		driver.findElement(By.xpath("")).sendKeys("");
		
		WebElement element = driver.findElement(By.cssSelector(".block.fs-11.mt10"));
		
		System.out.println(element.getCssValue("font-size"));
		
		System.out.println(element.getCssValue("background-color"));
		
		System.out.println(element.getCssValue("color"));
		
		System.out.println(element.getCssValue("background"));
		
		System.out.println(element.getCssValue("font-family"));
		
		
	}

}
