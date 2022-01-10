package com.seleniumInterviewQuestions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFIleUsingChrome {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver(); 

		driver.manage().deleteAllCookies();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		
		driver.findElement(By.xpath("//span[text()='Close']")).click();
		
		driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();


	}

}
