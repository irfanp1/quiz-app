package com.quizap;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class RegPoco {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "7023bd4d");
		URL url=new URL("http://0.0.0.0:4723/wd/hub");
		AndroidDriver<MobileElement> d=new AndroidDriver<MobileElement>(url, cap);
		cap.setCapability("appPackage", "com.mi.android.globallauncher");
		cap.setCapability("appActivity", "com.miui.home.launcher.Launcher");
		Thread.sleep(1000);
		d.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"QuizApp\"]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ImageView")).click();
		Thread.sleep(6000);
		d.findElement(By.id("com.example.quizapp:id/txtRegisterLink")).click();
		d.findElement(By.id("com.example.quizapp:id/etFirstName")).sendKeys("dsfdf");
		d.findElement(By.id("com.example.quizapp:id/etLastName")).clear();
		Thread.sleep(1000);
		d.findElement(By.id("com.example.quizapp:id/etLastName")).sendKeys("rgfsadfg");
		d.findElement(By.id("com.example.quizapp:id/etUserName")).sendKeys("fdsafg");
		d.findElement(By.id("com.example.quizapp:id/et_password")).sendKeys("Zoom@1233");
		d.findElement(By.id("com.example.quizapp:id/etEmailAddress")).sendKeys("ddn@fgs.sdj");
		d.findElement(By.id("com.example.quizapp:id/btnRegister")).click();
		System.out.println("Success");
		
		
	}

}
