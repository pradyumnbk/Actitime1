package com.actitime.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskList {

	@FindBy(xpath="//div[text()='Add New']")
	private WebElement addnewbtn;
	@FindBy(xpath="//div[text()='+ New Customer']")
	private WebElement newCustomerOption;
	@FindBy(xpath="//input[@placeholder='Enter Customer Name' and @class]")
	private WebElement cstmtbx;
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
	private WebElement cstmdesctbx;
	@FindBy(xpath="(//div[text()='- Select Customer -'])[1]")
	private WebElement selectcstmdropdown;
	@FindBy(xpath="//div[text()='Our company' and @class='itemRow cpItemRow ']")
	private WebElement ourcompanyoption;
	@FindBy(xpath="//div[text()='Create Customer']")
	private WebElement createcustomerbtn;
	@FindBy(xpath="//div[@class='titleEditButtonContainer']/div[1]")
	private WebElement actualcstmname;
	
	public WebElement getActualcstmname() {
		return actualcstmname;
	}

	public TaskList(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddnewbtn() {
		return addnewbtn;
	}

	public WebElement getNewCustomerOption() {
		return newCustomerOption;
	}

	public WebElement getCstmtbx() {
		return cstmtbx;
	}

	public WebElement getCstmdesctbx() {
		return cstmdesctbx;
	}

	public WebElement getSelectcstmdropdown() {
		return selectcstmdropdown;
	}

	public WebElement getOurcompanyoption() {
		return ourcompanyoption;
	}

	public WebElement getCreatecustomerbtn() {
		return createcustomerbtn;
	}
}
