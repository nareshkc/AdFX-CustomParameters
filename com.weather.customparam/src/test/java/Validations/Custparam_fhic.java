package Validations;

import com.Genaral.CustParam_Params;
import com.Genaral.Cust_param;
import com.Genaral.Driver;
import com.weather.excel.ExcelData;
import com.weather.excel.Write_result;

public class Custparam_fhic extends Driver{

	
	int fhic;
	public static String Result =null;
	public void fhic() throws Exception{


        
		String fhicvalue =	CustParam_Params.fhicvalue1;
				//Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[2]/UIATableView[1]/UIATableCell[2]/UIAStaticText[2]").getText();
		int fhic = Integer.parseInt(fhicvalue);
				System.out.println("int fhic is ::"+fhic );
		System.out.println("fhic value is ::"+fhicvalue);
		Cust_param cp = new Cust_param();
		if(cp.ParamType.equals("fhic")){

			//Read Excel
			String[][] data = new String[10][10];
			ExcelData er = new ExcelData();
			data = er.excelread("fhic");
          
				Write_result wrResult = new Write_result();
				
				for(int filln = 1;filln<=3;filln++){
					wrResult.WriteResult("fhic","n",filln,4);
				}
				
			//	String v1=data[1][2].toString();
				int val1 = Integer.parseInt(data[1][2]);
				int val2 = Integer.parseInt(data[2][2]);
				int val3 = Integer.parseInt(data[3][2]);
               // int val3 = Integer.parseInt(data[3][2]);
				if(fhic<=val2 && fhic >=val1){
					
					System.out.println("param limit is ::"+val2);
					System.out.println("Param Value is ::"+ data[2][3]);

					wrResult.WriteResult("fhic",fhicvalue,2,4);
					cp.Param_val = "Pass";
					

				}else if(fhic<val1){
					
					System.out.println("param limit is ::"+val1);
					System.out.println("Param Value is ::"+ data[1][3]);

					wrResult.WriteResult("fhic",fhicvalue,1,4);
					cp.Param_val = "Pass";

					
				}else if(fhic>=val3){
					
					System.out.println("param limit is ::"+val3);
					System.out.println("Param Value is ::"+ data[3][3]);

					wrResult.WriteResult("fhic",fhicvalue,3,4);
					cp.Param_val = "Pass";

					
				}else
				{
					wrResult.WriteResult("fhic","Nodata",1,4);
					cp.Param_val = "Fail";
					
				}
			



		}

	}
}
