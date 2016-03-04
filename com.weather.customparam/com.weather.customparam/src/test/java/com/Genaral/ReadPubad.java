package com.Genaral;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;

import com.Appium.Capabilities;

public class ReadPubad extends Driver{

	public void pubadread(String param) throws IOException{
		   

		String Cust_param = Ad.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[21]/UIAStaticText[1]")).getText();

		String TestFile = Cust_param;
		FileReader FR = new FileReader(TestFile);
		BufferedReader BR = new BufferedReader(FR);
		String Content = "";


		// Loop to read all lines one by one from file and print It.
		while ((Content = BR.readLine()) != null) {
			System.out.println(Content);
			System.out.println("Text lenth is: " + Content.charAt('&'));

			// BR.close();
			System.out.println("Index is :" + Content.indexOf(param+"="));

			// return mbrLastName;
			String entriesTxt = Content;
			String[] aEntriesText = entriesTxt.split("&");
			String totalEntriesText = aEntriesText[aEntriesText.length - 1];
			// return Integer.parseInt(totalEntriesText);
			int totalLength = aEntriesText.length;

			for (int i = 1; i <= totalLength; i++) {
				String FindText = aEntriesText[aEntriesText.length - i];
				// System.out.println("Lenth number is : "+(totalLength-i)+ ":"
				// + FindText);
				if (FindText.contains(param)) {
					String[] Value = FindText.split("=");
					String ExactValue = Value[Value.length - 1];
					System.out.println("The value is :" + ExactValue);
					if (ExactValue.contains("nl") || ExactValue.contains(param)) {
						System.out.println("NO Values found for ord");

					} else

					{
						System.out.println(param+" vales is :" + FindText.contains(param));
						System.out.println(FindText);
					}
				}

}
}
	}
	}