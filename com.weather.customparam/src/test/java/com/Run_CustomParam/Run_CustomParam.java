package com.Run_CustomParam;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.Appium.appiumnew;
import com.Genaral.Cust_param;
import com.Genaral.DeleteFile;
import com.Genaral.File_Exist;

public class Run_CustomParam {
  @Test
  public void Run_CustomParam() throws Exception {
	  Cust_param cp= new Cust_param();

		cp.custparam();
  }
  @BeforeTest
  public void beforeTest() throws Exception {
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
