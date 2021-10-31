package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"./chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://jqueryui.com/droppable/");
/*
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));

		driver.switchTo().frame(frame);*/
		
		Actions act=new Actions(driver);
		
		/*//Drag and Drop Method1
		
		WebElement dragable = driver.findElement(By.id("draggable"));
		WebElement dropable = driver.findElement(By.id("droppable"));
		act.dragAndDrop(dragable, dropable).build().perform();
		
		//Drag and Drop Method2
		
		act.clickAndHold(dragable).moveToElement(dropable).release().build().perform();
		*/
		
		//Mouse Movement
		
		WebElement supportElement = driver.findElement(By.linkText("Support"));
		act.moveToElement(supportElement).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Learning Center")).click();
		System.out.println(driver.getTitle());
		

		


	}

}
