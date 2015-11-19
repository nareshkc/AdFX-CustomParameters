package com.Run_CustomParam;

import com.Appium.Capabilities;
import com.Appium.Dcap;
import com.Appium.appiumnew;
import com.Genaral.Cust_param;
import com.Genaral.Cust_param1;
import com.Genaral.Driver;
import com.Genaral.ReadPubad;


public class Test extends Driver{

	public static void main(String[] args) throws Exception {

//		Capabilities cap = new Capabilities();
//		cap.dcap();
		
		appiumnew appium = new appiumnew();
		appium.main();

		Cust_param cp= new Cust_param();

		cp.custparam();
		
		//appium.stopAppiumServer();		
		

	}

}
