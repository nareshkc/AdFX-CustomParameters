package com.Genaral;

import io.appium.java_client.MobileElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class User_Login extends Driver{
	
	public void login() throws Exception{
		
		Excel_Path="Test_1";
	
//		app_Kill_Relaunch AKR =new app_Kill_Relaunch();
//		AKR.Kill_realaunch();
		
//		Ad.closeApp();
//		Ad.launchApp();
		
		//Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]").click();
		Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]").click();
		if(Ad.findElementByName("Log In").isDisplayed())
		{
		Ad.findElementByName("Log In").click();
		Thread.sleep(1000);
		//Ad.findElementByName("Email").sendKeys("naresh@monocept.com");
		Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]").sendKeys("naresh213@gmail.com");
		//Ad.findElementByName("Password (6 or more characters)").sendKeys("12345678");
		Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]").sendKeys("123456");
		Ad.findElementByName("Log In").click();
		System.out.println("User logged in successfully");
		Thread.sleep(8000);
		MobileElement Settings =(MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]");
//		WebDriverWait wait = new WebDriverWait(Ad, 10);
//		wait.until(ExpectedConditions.visibilityOf(Settings));
		Settings.click();
		Thread.sleep(3000);
		System.out.println("User on CC page - log in");
		
		}else
		{
			Thread.sleep(3000);
			Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]").click();
			System.out.println("User on CC page");
			
		}
		
		//UIAApplication[1]/UIAWindow[1]/UIAButton[2]
		Thread.sleep(3000);
		
		
	}
	

}
