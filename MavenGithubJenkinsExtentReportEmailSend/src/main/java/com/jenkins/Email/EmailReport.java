package com.jenkins.Email;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EmailReport {
ExtentReports extent=new ExtentReports();
ExtentSparkReporter spark=new ExtentSparkReporter("ExtentReport.html");
WebDriver driver;
@Parameters({"browser"})
@BeforeClass
public void open(String browser)
{
	Reporter.log("Open",true);
	extent.attachReporter(spark);
	if(browser.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	}
}
@Parameters({"url"})
@BeforeMethod
public void login(String url)
{
	Reporter.log("Login",true);
	driver.get(url);
}
@AfterMethod
public void logout()
{
	Reporter.log("Logout",true);
}
@AfterClass
public void close()
{
	Reporter.log("Close",true);
	extent.flush();
}
}
