package com.mani.qa;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoBlazeSignUPValidations {
	public static WebDriver driver;	

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver(); 

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.demoblaze.com/");

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));



	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	/*
	 * 1.SignUp TC
	 */

	@Test(priority=1)
	public void validateSignUpTest() {

		driver.findElement(By.id("signin2")).click();
		driver.findElement(By.cssSelector("#sign-username")).sendKeys("mm123456789@gmail.com");
		driver.findElement(By.cssSelector("#sign-password")).sendKeys("mani@123456789");
		driver.findElement(By.xpath("//button[normalize-space()='Sign up']")).click();
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String signUpSuccessText = alert.getText();
		alert.accept();
		Assert.assertEquals(signUpSuccessText, "Sign up successful.");

	}

	/*
	 * 2.Login TC
	 */


	@Test(priority=2)
	public void validateLoginTest() {

		driver.findElement(By.id("login2")).click();
		driver.findElement(By.id("loginusername")).sendKeys("mm123456789@gmail.com");
		driver.findElement(By.id("loginpassword")).sendKeys("mani@123456789");
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();

	}

	/*
	 * 3.Add to cart TC
	 */

	@Test(priority=3)
	public void validateAddToCartTest() {
		driver.findElement(By.cssSelector("li[class='nav-item active'] a[class='nav-link']")).click();
		driver.findElement(By.xpath("//a[text()='Phones']")).click();
		List<WebElement> categories = driver.findElements(By.cssSelector(".list-group>a"));
		for (WebElement category : categories) {
			if (category.getText().equals("Phones")) {
				category.click();
			}
		}
		driver.findElement(By.xpath("//a[normalize-space()='Samsung galaxy s6']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Add to cart']")).click();
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String addToCartText = alert.getText();
		alert.accept();
		Assert.assertEquals(addToCartText, "Product added");
		//div[@id='tbodyid']//div/h4/child::a
	}

	/*
	 * 4.Add contact TC
	 */

	@Test(priority=4)
	public void validateUpdateContactDetailsTest() {
		driver.findElement(By.xpath("//a[text()='Contact']")).click();
		driver.findElement(By.cssSelector("#recipient-email")).sendKeys("mani123@gmail.com");
		driver.findElement(By.cssSelector("#recipient-name")).sendKeys("mani");
		driver.findElement(By.cssSelector("#message-text")).sendKeys("");
		driver.findElement(By.xpath("//button[normalize-space()='Send message']")).click();
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String contactAddedText = alert.getText();
		alert.accept();
		Assert.assertEquals(contactAddedText, "Thanks for the message!!");


	}

	/*
	 * 5.purchase TC
	 */

	@Test(priority=5)
	public void validatePurchaseTest() {

		driver.findElement(By.id("cartur")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Place Order']")).click();
		driver.findElement(By.id("name")).sendKeys("mani");
		driver.findElement(By.id("country")).sendKeys("india");
		driver.findElement(By.id("city")).sendKeys("chennai");
		driver.findElement(By.id("card")).sendKeys("1234567890");
		driver.findElement(By.id("month")).sendKeys("November");
		driver.findElement(By.id("year")).sendKeys("2021");
		driver.findElement(By.xpath("//button[normalize-space()='Purchase']")).click();
		String thankyouText=	driver.findElement(By.xpath("//h2[normalize-space()='Thank you for your purchase!']")).getText();
		Assert.assertEquals(thankyouText, "Thank you for your purchase!");
		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();

	}
}
