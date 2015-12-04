package com.Genaral;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.weather.excel.ExcelData;
import com.weather.excel.WriteResultintoExcel;

public class Cust_param extends Driver {

	public void custparam() throws Exception{

		System.out.println("Case Started");

		//	//Ad.resetApp();

		//Verify File Exist or not


		//Call Capabilities

		//		
		//		
		String[] str ={"/bin/bash", "-c", "/usr/local/bin/idevicesyslog >> "+properties.getProperty("LogFilePath")};

		//Thread.sleep(10000);
		Process p = Runtime.getRuntime().exec(str);

		Thread.sleep(20000);
		//System.out.println("Writing is completed  :" + p.exitValue());
		BufferedReader r = new BufferedReader(new FileReader(properties.getProperty("LogFilePath")));

		String line = "";
		String allLine = "";

		while((line=r.readLine()) != null)
		{
			System.out.println("Sys data is ::"+line);


		}

		String FilePath = properties.getProperty("LogFilePath");

		Map<String, String> mapkeys = new HashMap<String, String>();

		try {
			FileInputStream fstream = new FileInputStream(FilePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;

			// / read log line by line ------ strLine = br.readLines(6, 10); /
			StringBuffer sb = new StringBuffer("");
			while ((strLine = br.readLine()) != null) {

				// parse strLine to obtain what you want /
				//System.out.println (strLine);
				sb.append(strLine);

			}

			for(int feed =1;feed<=5;feed++)
			{
				//if(sb.toString().contains("Requesting ad: /7646/app_iphone_us/display/feed/feed_1")){
				if(sb.toString().contains("Requesting ad: /7646/app_iphone_us/display/feed/feed_"+feed)){
					// System.out.println("index of first one ::::"+sb.toString().indexOf("Requesting ad: /7646/app_iphone_us/display/feed/feed_1 with parameters: {"));
					//System.out.println("index of second one ::::"+sb.toString().indexOf("Oct  9 12:43:59 iPod TheWeather[686] <Warning>: Get"));
					String req = sb.toString().substring( sb.toString().lastIndexOf("Requesting ad: /7646/app_iphone_us/display/feed/feed_"+feed+" with parameters: {"));
					String Cust_param = req.substring(req.indexOf("{")+1,req.indexOf("}"));
					req =req.replace("Requesting ad: /7646/app_iphone_us/display/feed/feed_1 with parameters: {", "");
					System.out.println("custom data ::"+Cust_param);
					String[] arrays = req.split(";");
					System.out.println("Verifing the "+req);

					String Content = Cust_param;

					//Read Excel
					String[][] data = new String[10][10];
					ExcelData er = new ExcelData();
					data = er.excelread();

					//First Test Cases

					for(int testcase=1;testcase<=43;testcase++)
					{

						String param = data[testcase][4].toString();
						System.out.println("The param is :"+ param);
						// Loop to read all lines one by one from file and print It.

						// return mbrLastName;// Getting ord value from Cust_param
						System.out.println("Verifing the "+req);
						for(String keys : arrays){
							System.out.println(keys);
							if(keys.contains("=")){
								String[] key = keys.split("=");
								// System.out.println(key[0] + "---"+key[1]);
								mapkeys.put(key[0], key[1]);




								if (param.trim().equals(key[0].trim())) {
									String ExactValue = key[key.length - 1];
									System.out.println("The value is :" + ExactValue);

									WriteResultintoExcel wResult = new WriteResultintoExcel();

									//String Compare

									//								if(data[testcase][4].contains("wind"))
									//								{
									//									String WindText=Ad.findElementByName("ENE 8 MPH").getText();
									//									String windarray[] = WindText.split(" ",3);
									//									System.out.println("Wind value is ::"+ windarray[1]);
									//
									//
									//								}

									int Getresult = feed*2;


									int ResultColumn_1=7+Getresult;
									int ResultColumn_2=8+Getresult;


									//If Value Size is NA
									if(data[testcase][6].contains("NA"))
									{
										if (data[testcase][8].contains(ExactValue.toString())&&ExactValue!="") {
											System.out.println("NO Values found for "+param);
											wResult.enterResult("SMOKE", "Fail", ExactValue, testcase, ResultColumn_1, ResultColumn_2);
										}else if(data[testcase][7].contains(ExactValue)||data[testcase][5].contains("Fixed")){
											System.out.println(param+" vales is :" + keys.contains(data[testcase][4].toString()));
											System.out.println(keys);
											wResult.enterResult("SMOKE", "Pass", ExactValue, testcase, ResultColumn_1, ResultColumn_2);
										}

										break;
									}


									//Verify Value Size is not NA data
									if(!data[testcase][6].contains("NA")){
										System.out.println("Exact Value is "+ ExactValue + " Data in Excel " + data[testcase][8]+" Size is : "+ExactValue.length());
										if (data[testcase][8].contains(ExactValue)&&(ExactValue.length() !=data[testcase][6].length())&&ExactValue!="") {
											System.out.println("NO Values found for "+param);
											wResult.enterResult("SMOKE", "Fail", ExactValue, testcase, ResultColumn_1, ResultColumn_2);

										} else

											if(data[testcase][7].contains(ExactValue)||data[testcase][5].contains("Not Fixed")){
												System.out.println(data[testcase][4]+" vales is :" + keys.contains(param));
												System.out.println(keys);
												wResult.enterResult("SMOKE", "Pass", ExactValue, testcase, ResultColumn_1, ResultColumn_2);
											}else if(data[testcase][7].contains(ExactValue)||data[testcase][5].contains("Fixed")){
												System.out.println(data[testcase][4]+" vales is :" + keys.contains(param));
												System.out.println(keys);
												wResult.enterResult("SMOKE", "Pass", ExactValue, testcase, ResultColumn_1, ResultColumn_2);
											}

									}

								}


							}
						}
					}
				}	
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Case Ended");
	}

}

