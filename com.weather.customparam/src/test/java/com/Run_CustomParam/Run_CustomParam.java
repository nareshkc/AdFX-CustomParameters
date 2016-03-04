package com.Run_CustomParam;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.Appium.appiumnew;
import com.Genaral.Cust_param;
import com.Genaral.DeleteFile;
import com.Genaral.Driver;
import com.Genaral.File_Exist;
import com.Genaral.Install_the_app;
import com.Genaral.PropertyFile;
import com.Genaral.User_Login;
import com.Genaral.firstRun;

public class Run_CustomParam extends Driver{
	
	
	@Test (priority =1)
	public void Run_CustomParam_Anonymoususer() throws Exception {
		Driver.property();
		PropertyFile.property();
		
		firstRun fr = new firstRun();
		fr.first_Run();

		//User Logged in
//		User_Login UL = new User_Login();
//		UL.login();
		
		String AnonymousExcelPath = properties.getProperty("AnonymousExcelFilePath");
		//String RegisterExcelPath = properties.getProperty("RegisterExcelFilePath");
		Cust_param cp= new Cust_param();

		cp.custparam();
	}
	
//	@Test (priority =1)
//	public void Run_CustomParam_RegisterUser() throws Exception {
//		Driver.property();
//		PropertyFile.property();
//		
//		User_Login UL = new User_Login();
//		UL.login();
//		
//		String RegisterExcelPath = properties.getProperty("RegisterExcelFilePath");
//		
//		Cust_param cp= new Cust_param();
//
//		cp.custparam();
//		
//	}
	@BeforeMethod
	public void beforeTest() throws Exception {

		
		//Check and Delete the log file befor the test 
				DeleteFile DF = new DeleteFile();
				File_Exist FE = new File_Exist();
				if(FE.fileexist()) {
					DF.deleteFile();

				} else {
					System.out.println("File not exist");
				}
		
		
		//Install the app
		Install_the_app install=new Install_the_app();
		install.install();
		Thread.sleep(2000);

		

		//Start appium and launch the app
		appiumnew appium = new appiumnew();
		appium.main();
		
		
		
		
	}

	@AfterTest
	public void afterTest() {
	}

}
