package Validations;

import io.appium.java_client.MobileElement;

import com.Genaral.CustParam_Params;
import com.Genaral.Cust_param;
import com.Genaral.Driver;
import com.weather.excel.ExcelData;
import com.weather.excel.Write_result;

public class Custparam_tmpr extends Driver{
	String tmpr_val=null;
	public static String Result =null;

	public void tmpr() throws Exception{


//		for(int i=1;i<=2;i++)
//		{
//			MobileElement el = (MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText["+i+"]");
//
//			System.out.println("Element el is ::"+el.getText());
//
//			if(el.getText().contains(" "))
//			{
//				System.out.println("Allert present");
//			}else
//			{
//
//				tmpr_val =el.getText();
//
//
//				break;
//			}
//		}
		tmpr_val=CustParam_Params.tmpr_val2;
		Cust_param cp = new Cust_param();
		//System.out.println("tmp value is ::"+tmp_val);
		//System.out.println("Param Type is ::"+cp.ParamType);
		String ActualTmpr = tmpr_val.replace("°", "");
		System.out.println("Actual Tmpr is :: "+ActualTmpr);
		if(cp.ParamType.equals("tmpr")){

			//Read Excel
			String[][] data = new String[10][10];
			ExcelData er = new ExcelData();
			data = er.excelread("tmpr");
			Write_result wrResult = new Write_result();
			System.out.println("tmpr value is:" + tmpr_val);

			for(int i =1;i<=8;i++){


				if(data[i][1].contains(ActualTmpr)){
					System.out.println("param limit is ::"+data[i][1]);
					System.out.println("Param Value is ::"+ data[i][2]);

					wrResult.WriteResult("tmpr",tmpr_val,i,3);
					cp.Param_val = "Pass";
					break;

				}else if(ActualTmpr.contains("-")){
					i=1;
					System.out.println("param limit is ::"+data[i][1]);
					System.out.println("Param Value is ::"+ data[i][2]);

					wrResult.WriteResult("tmpr",tmpr_val,i,3);
					cp.Param_val = "Pass";
					break;

				}else
				{
					if(i==8){
						System.out.println("param limit is ::"+data[i][1]);
						System.out.println("Param Value is ::"+ data[i][2]);

						wrResult.WriteResult("tmpr",tmpr_val,i,3);
						cp.Param_val = "Pass";
					}else
					{
						wrResult.WriteResult("tmpr","No data",i,3);
						System.out.println("Element not found");
						cp.Param_val = "Fail";
					}

				}

			}



		}
	}
}




