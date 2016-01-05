package Validations;

import io.appium.java_client.MobileElement;

import com.Genaral.CustParam_Params;
import com.Genaral.Cust_param;
import com.Genaral.Driver;
import com.weather.excel.ExcelData;
import com.weather.excel.Write_result;

public class Custparam_hmid extends Driver {
	int hmid;
	public static String Result =null;
	public void hmid() throws Exception{



		String hmidvalue =	CustParam_Params.hmidvalue2;
				//Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[2]/UIATableView[1]/UIATableCell[2]/UIAStaticText[2]").getText();
		hmidvalue = hmidvalue.replace("%", "");
		System.out.println("hmid value is ::"+hmidvalue);
		hmid = Integer.parseInt(hmidvalue);
		Cust_param cp = new Cust_param();
		
		System.out.println("Actual hmid is :: "+hmid);
		if(cp.ParamType.equals("hmid")){

			//Read Excel
			String[][] data = new String[10][10];
			ExcelData er = new ExcelData();
			data = er.excelread("hmid");
          
				Write_result wrResult = new Write_result();
				
				int val1=Integer.parseInt(data[1][2]);
                int val2 = Integer.parseInt(data[2][2]);
               // int val3 = Integer.parseInt(data[3][2]);
				if(hmid>=val2){
					
					System.out.println("param limit is ::"+val2);
					System.out.println("Param Value is ::"+ data[2][3]);

					wrResult.WriteResult("hmid",hmidvalue,2,4);
					cp.Param_val = "Pass";
					

				}else if(hmid<=val1){
					
					System.out.println("param limit is ::"+val1);
					System.out.println("Param Value is ::"+ data[1][3]);

					wrResult.WriteResult("hmid",hmidvalue,1,4);
					cp.Param_val = "Pass";

					
				}else
				{
					wrResult.WriteResult("hmid","No data",1,4);
					cp.Param_val = "Fail";
					
				}
			



		}

	}




}
