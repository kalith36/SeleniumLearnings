package com.seleniumInterviewQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseActions {

	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup(); 
		WebDriver driver= new ChromeDriver();
		
		driver.get("");
		WebElement ele=driver.findElement(By.id(""));
		
		Actions ac=new Actions(driver);
		
		ac.contextClick().perform();
		ac.doubleClick().perform();
		ac.dragAndDrop(ele, ele).perform();
		ac.clickAndHold().moveToElement(ele).release().perform();
		ac.sendKeys(Keys.ENTER).perform();
		ac.sendKeys(Keys.BACK_SPACE).perform();
		ac.sendKeys(Keys.SPACE).perform();
		ac.sendKeys(Keys.ESCAPE).perform();
		
		ac.keyDown(Keys.CONTROL);
		ac.sendKeys("a");
		ac.keyUp(Keys.CONTROL);
		ac.perform();
		
		ac.sendKeys(Keys.TAB);
		ac.perform();
		
	
	
	}

}
