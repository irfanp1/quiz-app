package com.quizap;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.remote.MobileCapabilityType;

public class login {
	static AndroidDriver<MobileElement> d;
	
	@Test(priority = 1)
	public void quiz() throws InterruptedException, MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		URL url=new URL("http://0.0.0.0:4723/wd/hub");
		d = new AndroidDriver<MobileElement>(url, cap);
		cap.setCapability("appPackage", "com.google.android.apps.nexuslauncher");
		cap.setCapability("appActivity", "com.google.android.apps.nexuslauncher.NexusLauncherActivity");
		Thread.sleep(1000);
	}
	@Test(priority = 2,dataProvider = "data")
		void log(String un, String pwd,String val1,String val2,String val3,String val4,String val5,String val6,String val7,String val8,String val9,String val10) throws InterruptedException {
			Thread.sleep(3000);  
		d.findElement(By.xpath("//android.widget.TextView[@content-desc=\"QuizApp\"]")).click();
		Thread.sleep(7000);
		System.out.println("user name    = "+un);
		d.findElement(By.id("com.example.quizapp:id/et_userName")).sendKeys(un);
		d.findElement(By.id("com.example.quizapp:id/et_password")).sendKeys(pwd);Thread.sleep(2000);
		d.findElement(By.id("com.example.quizapp:id/btnLogin")).click();Thread.sleep(3000);
		d.findElement(By.id("com.example.quizapp:id/checkboxIagree")).click();Thread.sleep(2000);
		d.findElement(By.id("com.example.quizapp:id/btnStartQuiz")).click();Thread.sleep(9000);
		

		if (val1.contains("2")) {
			MobileElement a1 = d.findElements(By.id("com.example.quizapp:id/imgHideShowCorrectAnswer")).get(2);//1st question-3
		a1.click();
		Thread.sleep(10000);
		} else {
			Thread.sleep(9000);
		}
		
		if (val2.contains("1")) {
		MobileElement a2 = d.findElements(By.id("com.example.quizapp:id/imgHideShowCorrectAnswer")).get(1);//2nd question-2
		a2.click();	
		Thread.sleep(9000);
		
		} else {
			Thread.sleep(9000);
		}
		if (val3.contains("2")) {
			MobileElement a3 = d.findElements(By.id("com.example.quizapp:id/imgHideShowCorrectAnswer")).get(2);//3rd question-3
		a3.click();
		Thread.sleep(9000);
		} else {
			Thread.sleep(9000);
			}
		if (val4.contains("0")) {
			d.findElements(By.id("com.example.quizapp:id/imgHideShowCorrectAnswer")).get(0).click();//4th question-1
			Thread.sleep(9000);
		} else {
			Thread.sleep(9000);
			}
		
		if (val5.contains("3")) {
			d.findElements(By.id("com.example.quizapp:id/imgHideShowCorrectAnswer")).get(3).click();//5th question-4
			Thread.sleep(9000);
		} else {
			Thread.sleep(9000);
			}
		
		if (val6.contains("0")) {
			d.findElements(By.id("com.example.quizapp:id/imgHideShowCorrectAnswer")).get(0).click();//6th question-1
			Thread.sleep(9000);
		} else {
			Thread.sleep(9000);
			}
		
		if (val7.contains("2")) {
			d.findElements(By.id("com.example.quizapp:id/imgHideShowCorrectAnswer")).get(2).click();//7th question-3
			Thread.sleep(9000);
		} else {
			Thread.sleep(9000);
			}
		if (val8.contains("2")) {
			d.findElements(By.id("com.example.quizapp:id/imgHideShowCorrectAnswer")).get(2).click();Thread.sleep(9000);//8th question-3
		} else {
			Thread.sleep(9000);
			}
		if (val9.contains("3")) {
			d.findElements(By.id("com.example.quizapp:id/imgHideShowCorrectAnswer")).get(3).click();Thread.sleep(9000);//9th question-4
		} else {
			Thread.sleep(9000);
			}
		if (val10.contains("1")) {
		d.findElements(By.id("com.example.quizapp:id/imgHideShowCorrectAnswer")).get(1).click();Thread.sleep(20000);//10th question-2
		d.findElement(By.xpath("//android.widget.Button[@text=\"GO TO RESULTS\"]")).click();Thread.sleep(3000);
		System.out.println("Right	-"+d.findElement(By.id("com.example.quizapp:id/txtRightAnswersResult")).getText());
		System.out.println("Wrong	-"+d.findElement(By.id("com.example.quizapp:id/txtWrongAnswersResult")).getText());
			System.out.println("Total	-"+d.findElement(By.id("com.example.quizapp:id/txtTotalMarksResult")).getText());
			System.out.println("Status	-"+d.findElement(By.id("com.example.quizapp:id/txtStatusResult")).getText());Thread.sleep(2000);
		d.findElement(By.xpath("//android.widget.Button[@text=\"EXIT\"]")).click();
		} else {
			Thread.sleep(22000);
			d.findElement(By.xpath("//android.widget.Button[@text=\"GO TO RESULTS\"]")).click();Thread.sleep(3000);
			System.out.println("Right	-"+d.findElement(By.id("com.example.quizapp:id/txtRightAnswersResult")).getText());
			System.out.println("Wrong	-"+d.findElement(By.id("com.example.quizapp:id/txtWrongAnswersResult")).getText());
				System.out.println("Total	-"+d.findElement(By.id("com.example.quizapp:id/txtTotalMarksResult")).getText());
				System.out.println("Status	-"+d.findElement(By.id("com.example.quizapp:id/txtStatusResult")).getText());Thread.sleep(2000);
			d.findElement(By.xpath("//android.widget.Button[@text=\"EXIT\"]")).click();
		}
		Thread.sleep(3000);  	
	}
	@DataProvider(name="data")
	String[][] data() throws IOException{
		  /*String[][] value=new String[3][1];
		  value[0][0]= "HR Associate";
		value[1][0]="IT Manager";
		 value[2][0]="Sales Representative";*/
		 
		 String path="C:\\Users\\ciadmin\\Desktop\\test.xlsx";
		 Use util=new Use(path); 
		 int rows=util.getrowcount("Sheet3");
		 int col=util.getcellcount("Sheet3",1);
		 String value[][]=new String[rows][col];
		 for(int i=1;i<=rows;i++) {
		for(int j=0;j<col;j++) {
			 value[i-1][j]=util.getcelldata("sheet3",i,j);
			
			}
	}
		  return value;
	  }
	
	

}
