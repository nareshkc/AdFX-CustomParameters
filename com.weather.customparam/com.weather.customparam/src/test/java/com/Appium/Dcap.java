package com.Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.ios.IOSDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.Genaral.Driver;

public class Dcap extends Driver{
	
	public void cap() throws MalformedURLException{
		
		 DesiredCapabilities capabilities = new DesiredCapabilities();

		  capabilities.setCapability("automationName", "Appium");
		  capabilities.setCapability("browserName", "");
		  capabilities.setCapability("autoLaunch",true);
		  capabilities.setCapability("platfromName","iOS");
		  capabilities.setCapability("platfromVersion","8.3");
		  capabilities.setCapability("deviceName","adurgam’s iPhone");
		  capabilities.setCapability("udid","c87e18b1235f1480f32f2725762260fb893492b9");
		  capabilities.setCapability("bundleId","com.weather.TWC");
		  capabilities.setCapability("app","/Users/aparna/Downloads/The Weather 6.10.ipa");
		  capabilities.setCapability("showIOSLog",true);

		  driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		 driver.manage().timeouts().implicitlyWait(180,TimeUnit.SECONDS);

		  driver.quit();
	}

}
