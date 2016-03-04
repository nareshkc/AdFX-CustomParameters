package com.Run_CustomParam;

import com.Appium.Capabilities;
import com.Appium.Dcap;
import com.Appium.Install_the_app;
import com.Appium.appiumnew;
import com.Genaral.Cust_param;
import com.Genaral.Cust_param1;
import com.Genaral.DeleteFile;
import com.Genaral.Driver;
import com.Genaral.File_Exist;
import com.Genaral.ReadPubad;




public class Test extends Driver{

	public static void main(String[] args) throws Exception {

		




		//Install the app
//		Install_the_app install=new Install_the_app();
//		install.install();
//		Thread.sleep(2000);



		//		Capabilities cap = new Capabilities();
		//		cap.dcap();
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

		//Verify Custom parameters
		Cust_param cp= new Cust_param();

		//cp.custparam();

		//appium.stopAppiumServer();	
		
		
		//Ad.close();
		//Ad.quit();


	}

}
