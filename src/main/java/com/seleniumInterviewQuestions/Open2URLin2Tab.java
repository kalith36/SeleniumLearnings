package com.seleniumInterviewQuestions;

import java.awt.Window;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Open2URLin2Tab {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver(); 
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get("https://demo.nopcommerce.com/");
		//open in new tab
		//driver.switchTo().newWindow(WindowType.TAB);
		//open in new window or browser window
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.opencart.com/");
	}

}
