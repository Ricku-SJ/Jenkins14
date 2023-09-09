package com.jenkins.Email;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestExx extends EmailReport{
@Test
public void create()
{
	Reporter.log("Create",true);
ExtentTest test=extent.createTest("This test case executed").assignAuthor("Ricku").
assignDevice("Smoke Test").assignDevice("HP");
test.log(Status.PASS,"It can access all credentials");
test.pass("This test executed properly");
test.info("username alerts");
test.warning("It is showing username alerts");
}
@Test
public void modify()
{
	Reporter.log("Modify",true);
	ExtentTest test=extent.createTest("This test case executed").assignAuthor("Ricku").
			assignDevice("Smoke Test").assignDevice("HP");
			test.log(Status.FAIL,"It can access all credentials");
			test.fail("This test executed properly");
			test.info("username alerts");
			test.warning("It is showing username alerts");
}
}
