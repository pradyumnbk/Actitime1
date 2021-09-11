package com.actitime.generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.actitime.pomrepository.EnterTimeTrack;
import com.actitime.pomrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseCls {
	
	public static WebDriver staticDriver;

	
	public  static WebDriver driver;
	@BeforeTest
	public void openBrowser()
	{
		WebDriverManager.chromedriver().setup();
		Reporter.log("open browser", true);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		staticDriver=driver;
	}
	@AfterTest
	public void closeBrowser()
	{
		Reporter.log("close browser", true);
		driver.close();
	}
	@BeforeMethod
	public void login() throws IOException
	{
		Reporter.log("login", true); 
		FileLib f=new FileLib();
		String url = f.getProperty("url");
		driver.get(url);
		LoginPage lp=new LoginPage(driver);
		String un = f.getProperty("un");
		String pwd = f.getProperty("pwd");
		lp.setLoginPage(un, pwd);
	}
	@AfterMethod
	public void logout()
	{
		
		EnterTimeTrack e=new EnterTimeTrack(driver);
		e.getLout().click();
		Reporter.log("logout",true);
	}
	
}
