package com.testNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TesttestNG {
	
	@BeforeMethod
	public void start()
	{
		System.out.println("starting");
	}
	
	@Test
	public void run() {
		System.out.println("Running");
	}
	
	@AfterMethod
	public void stop()
	{
		System.out.println("stoping");
	}

}
