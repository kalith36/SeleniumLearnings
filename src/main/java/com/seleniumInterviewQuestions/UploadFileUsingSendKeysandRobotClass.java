package com.seleniumInterviewQuestions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFileUsingSendKeysandRobotClass {

	public static void main(String[] args) throws AWTException, InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver(); 

		driver.manage().deleteAllCookies();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.monsterindia.com/");

		driver.findElement(By.cssSelector(".block.fs-11.mt10")).click();

		//Use by SendKeys
		
		/*driver.findElement(By.cssSelector("#file-upload")).sendKeys("C:\\Users\\Ahamed Razik\\Downloads\\dummy1.txt");*/

		//use by Robot class

		WebElement fileUploadButton = driver.findElement(By.cssSelector("#file-upload"));

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", fileUploadButton);

		Robot rb = new Robot();

		rb.delay(2000);

		//Copy the file path to system clipboard

		StringSelection ss = new StringSelection("C:\\Users\\Ahamed Razik\\Downloads\\dummy1.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		rb.delay(2000);
		//Paste the path

		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.delay(2000);

		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		rb.delay(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.delay(2000);
		rb.keyRelease(KeyEvent.VK_ENTER);
		 












	}

}
