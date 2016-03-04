package com.Genaral;

import io.appium.java_client.MobileElement;

public class CustParam_Params extends Driver {

	public static String uvvalue2 =null;
	public static String hmidvalue2 =null;
	public static String tmp_val2=null;
	public static String tmpr_val2=null;
	public static String windvalue2 =null;
	public static String sevvalue1 =null;
	public static String fltmpcvalue1=null;
	public static String flocvalue1 = null;
	public static String fhicvalue1 = null;
	public static String tmpcvalue1 =null;
	public static String stvalue1 =null;
	
	
	public void params(){

		 stvalue1 = Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[1]").getText();
		 								   //UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[1]
		 
		 System.out.println("Address is ::"+stvalue1);
		
		
		String tmp_val1 = null;
		String tmpr_val1 = null;
		String fhfl =null;
		//Tmp Value
		for(int i=1;i<=2;i++)
		{
			MobileElement el = (MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText["+i+"]");

			System.out.println("Element el is ::"+el.getText());

			if(el.getText().contains(" "))
			{
				MobileElement el1 = (MobileElement) Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[2]");

				System.out.println("Allert present");
				sevvalue1 = el.getText();
				System.out.println("sevvalue is ::"+sevvalue1);
				tmp_val1=el1.getText();
				tmpr_val1 =el1.getText();
				fhfl = Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[4]").getText();
				
				break;
			}else
			{

				tmp_val1=el.getText();
				tmpr_val1 =el.getText();
				sevvalue1="No allert";
				fhfl = Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[3]").getText();
				break;
			}
		}

		//floc values are
        System.out.println("fhfl value is ::"+fhfl);
		String [] flfh = fhfl.split("/");
		if(flfh[1].toString().contains("--")){
			flocvalue1 = "-17";
		}else{
			flocvalue1 = flfh[1].toString().replace("°", "");
			int flocvalue2 = Integer.parseInt(flocvalue1);
			flocvalue2 =flocvalue2-32;
			double flocvalue3 =(double) ((flocvalue2)*(0.55));
			flocvalue3 =Math.round(flocvalue3);
			flocvalue2 = (int)flocvalue3;
			flocvalue1 =Integer.toString(flocvalue2);
			System.out.println("converted floc ::"+flocvalue1);
			
			
		}

		// tmpc values are
		
		tmpcvalue1=tmp_val1.toString();
		tmpcvalue1 = tmpcvalue1.replace("°", "");
		int tmpcvalue2 = Integer.parseInt(tmpcvalue1);
		tmpcvalue2 = tmpcvalue2-32;
		double  tmpcvalue3 = (double) ((tmpcvalue2)*(0.55));
		tmpcvalue3 = Math.round(tmpcvalue3);
		System.out.println("double value is::"+tmpcvalue3);
		tmpcvalue2=(int) tmpcvalue3;
		tmpcvalue1 = Integer.toString(tmpcvalue2);
		System.out.println("converted tmpc ::"+tmpcvalue1);
		
		
		// fhic values are
		if(flfh[0].toString().contains("--")){
			fhicvalue1 = "-17";
		}else{
			fhicvalue1 = flfh[0].toString().replace("°", "");
			int fhicvalue2 = Integer.parseInt(fhicvalue1);
			fhicvalue2 =fhicvalue2-32;
			double fhicvalue3 =(double) ((fhicvalue2)*(0.55));
			//fhicvalue3 =Math.round(fhicvalue3);
			fhicvalue2 = (int)fhicvalue3;
			fhicvalue1 =Integer.toString(fhicvalue2);
			System.out.println("converted fhic ::"+fhicvalue1);
		}
		String fltmpcvalue2 =null;
		int i;
		//fltmpc values is
		if(Excel_Path.contains("Login")){
			
			i=2;
			//fltmpcvalue2 = Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell["+i+"]/UIAStaticText[2]").getText();
		}else{
			i=2;
			//fltmpcvalue2 = Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell["+i+"]/UIAStaticText[2]").getText();
		}      
		fltmpcvalue2 = Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell["+i+"]/UIAStaticText[2]").getText();
		
		//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[4]/UIAStaticText[2]
		System.out.println("fltmpc is ::"+fltmpcvalue2);
		fltmpcvalue2=fltmpcvalue2.replace("°", "");
		int fltmpcvalue3 = Integer.parseInt(fltmpcvalue2);
		fltmpcvalue3 = fltmpcvalue3-32;
		double  fltmpcvalue4 = (double) ((fltmpcvalue3)*(0.55));
		fltmpcvalue4 = Math.round(fltmpcvalue4);
		System.out.println("double value is::"+fltmpcvalue4);
		fltmpcvalue3=(int) fltmpcvalue4;
		fltmpcvalue1 = Integer.toString(fltmpcvalue3);
		System.out.println("converted fltmpc ::"+fltmpcvalue1);



		//tmp value is
		tmp_val2 = tmp_val1.toString();


		//tmpr value is
		tmpr_val2 = tmpr_val1.toString();
		//hmid Variable value

		String hmidvalue1 =	Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell["+i+"]/UIATableView[1]/UIATableCell[2]/UIAStaticText[2]").getText();
		hmidvalue2 = hmidvalue1.toString();        //UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[4]/UIATableView[1]/UIATableCell[2]/UIAStaticText[2]
		//UV Variable value
		String uvvalue1 =	Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell["+i+"]/UIATableView[1]/UIATableCell[5]/UIAStaticText[2]").getText();
		uvvalue2 =uvvalue1.toString();

		//wind Variable value
		String windvalue1 =	Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell["+i+"]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]").getText();
		windvalue2 = windvalue1.toString();
	}
}
