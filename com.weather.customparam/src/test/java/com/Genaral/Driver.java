package com.Genaral;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;

public class Driver extends PropertyFile {

	protected static WebDriver driver;
	protected static AppiumDriver Ad ;
	public void Dr()
	{
		driver=null;
		Ad=null;
		
	}
	
	public boolean isElemenetPresent(By by) throws Exception
	{
		
		try{
			driver.findElement(by);
			Ad.findElement(by);
		return true;
		}catch (NoSuchElementException e){
		return false;
		}
	}
}
