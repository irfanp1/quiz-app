package com.quizap;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Register {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
	DesiredCapabilities cap=new DesiredCapabilities();
	cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
	URL url=new URL("http://0.0.0.0:4723/wd/hub");
	AndroidDriver<MobileElement> ad=new AndroidDriver<MobileElement>(url, cap);
	cap.setCapability("appPackage", "com.google.android.apps.nexuslauncher");
	cap.setCapability("appActivity", "com.google.android.apps.nexuslauncher.NexusLauncherActivity");
	Thread.sleep(3000);
	ad.findElement(By.xpath("//android.widget.TextView[@content-desc=\"QuizApp\"]")).click();
	Thread.sleep(7000);
	ad.findElement(By.id("com.example.quizapp:id/txtRegisterLink")).click();Thread.sleep(2000);
	ad.findElement(By.id("com.example.quizapp:id/etFirstName")).sendKeys("dsfdf");Thread.sleep(2000);
	ad.findElement(By.id("com.example.quizapp:id/etLastName")).clear();
	Thread.sleep(2000);
	ad.findElement(By.id("com.example.quizapp:id/etLastName")).sendKeys("rgfsadfg");Thread.sleep(2000);
	ad.findElement(By.id("com.example.quizapp:id/etUserName")).sendKeys("fdsafg");Thread.sleep(2000);
	ad.findElement(By.id("com.example.quizapp:id/et_password")).sendKeys("Zoom@1233");Thread.sleep(2000);
	ad.findElement(By.id("com.example.quizapp:id/etEmailAddress")).sendKeys("ddn@fgs.sdj");Thread.sleep(2000);
	ad.findElement(By.id("com.example.quizapp:id/btnRegister")).click();
	System.out.println("Success");
	
	}

}
