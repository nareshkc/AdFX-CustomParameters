package com.Genaral;

import io.appium.java_client.MobileElement;

public class CustParam_Params extends Driver {

	public static String uvvalue2 =null;
	public static String hmidvalue2 =null;
	public static String tmp_val2=null;
	public static String tmpr_val2=null;
	public static String windvalue2 =null;
	public static String sevvalue1 =null;
	public void params(){

		String tmp_val1 = null;
		String tmpr_val1 = null;
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
				break;
			}else
			{

				tmp_val1=el.getText();
				tmpr_val1 =el.getText();
                sevvalue1="No allert";

				break;
			}
		}


		//tmp value is
		tmp_val2 = tmp_val1.toString();


		//tmpr value is
		tmpr_val2 = tmpr_val1.toString();
		//hmid Variable value

		String hmidvalue1 =	Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[2]/UIATableView[1]/UIATableCell[2]/UIAStaticText[2]").getText();
		hmidvalue2 = hmidvalue1.toString();
		//UV Variable value
		String uvvalue1 =	Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[2]/UIATableView[1]/UIATableCell[5]/UIAStaticText[2]").getText();
		uvvalue2 =uvvalue1.toString();

		//wind Variable value
		String windvalue1 =	Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[2]").getText();
		windvalue2 = windvalue1.toString();
	}
}
