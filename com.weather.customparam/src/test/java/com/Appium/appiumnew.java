package com.Appium;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.Genaral.Driver;
import com.Genaral.PropertyFile;



public class appiumnew extends Driver{

	public static void main() throws Exception {

		//Auto start Appium
		Start_Stop_AppiumServer appiumStart = new Start_Stop_AppiumServer();
		System.out.println("Stopping the appium server");
		appiumStart.stopAppiumServer();
		System.out.println("Appium server is stopped");
		//Thread.sleep(10000);
		System.out.println("Starting the appium server");
		appiumStart.startAppiumServer();
		System.out.println("Appium server is started and running");


		Driver.property();
		PropertyFile.property();

		//Capabilities
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium-version", "1.4.8");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "8.4");
		capabilities.setCapability("platform", "Mac");

		capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS");
		capabilities.setCapability("device", "iPod");
		capabilities.setCapability("bundleId", "com.weather.TWC");

		capabilities.setCapability("deviceName", "="+properties.getProperty("Device1"));
		//iPod (8.4) [707cc1d9c294b37fe5e70b7584163a100ae6166f]");
		//capabilities.setCapability("deviceName", "=iPhone 6 (8.4 Simulator) [360B61F0-0EBC-480C-B3A1-F80684FA193E]");
		capabilities.setCapability("forceIphone", true);

		//capabilities.setCapability("udid","707cc1d9c294b37fe5e70b7584163a100ae6166f");
		capabilities.setCapability("app", "/Users/aparna/Documents/Naresh/com.weather.customparam/build/TheWeather.ipa");
				//Users/aparna/Downloads/weat/TheWeather.app");
				//properties.getProperty("appPath"));
		capabilities.setCapability("appPackage", "com.weather.Weather");
		capabilities.setCapability("appActivity", "com.weather.Weather.app.SplashScreenActivity");
		capabilities.setCapability("newCommandTimeout", 100000);
		capabilities.setCapability("autoAcceptAlerts",true);
		System.out.println("Capabilities done");
		Thread.sleep(70000);
		 Ad = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		Ad.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("Working fine");

		

	}
	



}
