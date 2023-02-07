package com.quizap;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Regfull {
	static AndroidDriver<MobileElement> d;
	@Test(priority = 1)
	 void reg() throws MalformedURLException, InterruptedException{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		URL url=new URL("http://0.0.0.0:4723/wd/hub");
		d = new AndroidDriver<MobileElement>(url, cap);
		cap.setCapability("appPackage", "com.google.android.apps.nexuslauncher");
		cap.setCapability("appActivity", "com.google.android.apps.nexuslauncher.NexusLauncherActivity");
		Thread.sleep(3000);
		d.findElement(By.xpath("//android.widget.TextView[@content-desc=\"QuizApp\"]")).click();
		Thread.sleep(7000);
	}
		@Test(priority = 2,dataProvider = "data")
		void fun(String fn, String ln,String un,String pwd,String email) throws InterruptedException{
			
		d.findElement(By.id("com.example.quizapp:id/txtRegisterLink")).click();Thread.sleep(1000);
		d.findElement(By.id("com.example.quizapp:id/etFirstName")).sendKeys(fn);Thread.sleep(1000);
		d.findElement(By.id("com.example.quizapp:id/etLastName")).clear();
		Thread.sleep(2000);
		d.findElement(By.id("com.example.quizapp:id/etLastName")).sendKeys(ln);Thread.sleep(1000);
		d.findElement(By.id("com.example.quizapp:id/etUserName")).sendKeys(un);Thread.sleep(1000);
		d.findElement(By.id("com.example.quizapp:id/et_password")).sendKeys(pwd);Thread.sleep(1000);
		d.findElement(By.id("com.example.quizapp:id/etEmailAddress")).sendKeys(email);Thread.sleep(2000);
		d.findElement(By.id("com.example.quizapp:id/btnRegister")).click();Thread.sleep(3000);
		System.out.println("Success"+"   -     "+un);
		}
	
		@DataProvider(name="data")
		String[][] data() throws IOException{
			  /*String[][] value=new String[3][1];
			  value[0][0]= "HR Associate";
			value[1][0]="IT Manager";
			 value[2][0]="Sales Representative";*/
			 
			 String path="C:\\Users\\ciadmin\\Desktop\\test.xlsx";
			 Use util=new Use(path);
			 int rows=util.getrowcount("Sheet1");
			 int col=util.getcellcount("Sheet1",1);
			 String value[][]=new String[rows][col];
			 for(int i=1;i<=rows;i++) {
			for(int j=0;j<col;j++) {
				 value[i-1][j]=util.getcelldata("sheet1",i,j);
				
				}
		}
			  return value;
		  }
		
	
}

