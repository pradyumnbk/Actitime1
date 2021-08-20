package com.actitime.generic;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class WebdriverCommonLibCls {

	public static String takeScreenShot(WebDriver driver, String testcaseName) throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir")+"/screenshot"+testcaseName+".png";
		File dest = new File(screenshotPath);
		Files.copy(src, dest);
		return screenshotPath;
	}
}
