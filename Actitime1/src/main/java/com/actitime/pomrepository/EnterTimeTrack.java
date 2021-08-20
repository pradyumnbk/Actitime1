package com.actitime.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterTimeTrack {

	@FindBy(id="logoutLink")
	private WebElement lout;
	@FindBy(xpath="//div[text()='Tasks']")
	private WebElement tasks;
	
	public EnterTimeTrack(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLout() {
		return lout;
	}

	public WebElement getTasks() {
		return tasks;
	}
	
	
}
