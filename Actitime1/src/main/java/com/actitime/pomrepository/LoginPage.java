package com.actitime.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id="username")
	private WebElement usntbx;
		@FindBy(name="pwd")
		private WebElement pswtbx;
		@FindBy(xpath="//div[text()='Login ']")
		private WebElement login;
		
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
	public void setLoginPage(String un, String pwd)
	{
		usntbx.sendKeys(un);
		pswtbx.sendKeys(pwd);
		login.click();
	}
	
}
