package com.Run_CustomParam;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.Appium.appiumnew;
import com.Genaral.Cust_param;
import com.Genaral.DeleteFile;
import com.Genaral.File_Exist;
import com.Genaral.Install_the_app;

public class Run_CustomParam {
	@Test
	public void Run_CustomParam() throws Exception {
		Cust_param cp= new Cust_param();

		cp.custparam();
	}
	@BeforeTest
	public void beforeTest() throws Exception {

		//Install the app
		Install_the_app install=new Install_the_app();
		install.install();
		Thread.sleep(2000);


		//Start appium and launch the app
		appiumnew appium = new appiumnew();
		appium.main();
		//Check and Delete the log file befor the test 
		DeleteFile DF = new DeleteFile();
		File_Exist FE = new File_Exist();
		if(FE.fileexist()) {
			DF.deleteFile();

		} else {
			System.out.println("File not exist");
		}
	}

	@AfterTest
	public void afterTest() {
	}

}
