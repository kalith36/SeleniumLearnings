package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver", "C:/Users/Ahamed Razik/Downloads/chromedriver_win32/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.gmail.com");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@jsname='WjL7X']/div/button")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//li[@jsname='RZzeR']")).click();
		
		driver.findElement(By.xpath("//div[@id='accountDetailsNext']/div/button")).click();
		
		WebElement fnErr = driver.findElement(By.xpath("//*[@id=\"nameError\"]/div[2]/span"));
		
		String fnErrMsg = fnErr.getText();
		
		System.out.println(fnErrMsg);
		
		System.out.println(driver.getTitle());
		
		/*driver.findElement(By.xpath("//input[@type='email']")).sendKeys("defef");
		
		driver.findElement(By.xpath("//div[@id='identifierNext']/div/button")).click();
		
		Thread.sleep(5000);
		
		WebElement errorMSG = driver.findElement(By.xpath("(//div[@class='o6cuMc']/text())"));
		
		String errMSG =errorMSG.getText();
		
		System.out.println(errorMSG);
		
		if (errMSG.equals("couldn't find your Google Account")) {
			System.out.println("The test is Passed");
		}else {
			System.out.println("The test is failed");
		}
		
		*/
		/*Thread.sleep(10000);
		driver.close();*/
	}

}
