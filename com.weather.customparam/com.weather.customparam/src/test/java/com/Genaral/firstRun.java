package com.Genaral;

import io.appium.java_client.MobileElement;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.ITestResult;


/**
 * 
 * @author Naresh
 *
 */
public class firstRun extends Driver{



	@SuppressWarnings("deprecation")
	public void first_Run() throws InterruptedException
	{
		Excel_Path="Anonymous";
		
		String originalContext = Ad.getContext();
		Ad.context("NATIVE_APP");
		
		MobileElement TempEle =null;

		//verify temp element is present
		try{
			TempEle=(MobileElement) Ad.findElementByClassName("UIASearchBar");

			if(!TempEle.isDisplayed()){
				System.out.println("User On CC page - First run");
				
				
			}else

			{

//				//	Ad.findElementByName("topNav plus").click();
//				Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]").click();
//				//Ad.findElementByName("topNav settings").click();
//				Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]").click();
//				if(Ad.findElementByName("Follow Me Forecast, Weather for your current location").isSelected())
//				{
//					System.out.println("LBS is already enabled");
//
//				}else
//				{
//					Ad.findElementByName("Follow Me Forecast, Weather for your current location").click();
//					System.out.println("LBS is enabled");
//				}
//
//				//				Ad.findElementByName("topNav settings").click();
//				//				Ad.findElementByName("topNav plus").click();
//				Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]").click();
//				Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]").click();

				TempEle.click();
				TempEle.sendKeys("83702");

				Thread.sleep(2000);
				Ad.findElementByName("Search").click();
			
				Thread.sleep(3000);
				List<MobileElement> Areas = Ad.findElementsByName("Search results");
				System.out.println("Areas are ::"+Areas.size());
				
				Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]").click();
				Thread.sleep(2000);   
				
				//Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]").click();
			
			}


			try{
				MobileElement Address = (MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIACollectionView[1]/UIACollectionCell[3]/UIAStaticText[1]");
				System.out.println("Address is ::"+Address.getText());
				if(!Address.isDisplayed())
				{
					//Click on + icon
					//Ad.findElementByName("topNav plus").click();
					
					Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]").click();
					Ad.findElementByClassName("UIASearchBar").click();
					Ad.findElementByClassName("UIASearchBar").sendKeys("10016");
					Ad.findElementByName("Search").click();
					
					Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]").click();
				
				}else{
					System.out.println("Address Found ::"+Address.toString());
				}
			}catch(NoSuchElementException e)
			{
				System.out.println("Address is present");

			}

			//}
			

		}catch(NoSuchElementException e)
		{
			System.out.println("User On CC page after all try catch");
//			Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]").click();
//			Ad.findElementByClassName("UIASearchBar").click();
//			Ad.findElementByClassName("UIASearchBar").sendKeys("10016");
//			Ad.findElementByName("Search").click();
//			Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]").click();
//			System.out.println("User selected us address");
//			Thread.sleep(2000);
			
			

		}
		
	}
}
