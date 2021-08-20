package com.actitime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseCls;
import com.actitime.generic.FileLib;
import com.actitime.pomrepository.EnterTimeTrack;
import com.actitime.pomrepository.TaskList;

@Listeners(com.actitime.generic.ListenerImplementation.class)
public class CustomerModule extends BaseCls
{
	@Test
	public void testCreateCustomer() throws EncryptedDocumentException, IOException, InterruptedException
	{
		EnterTimeTrack e=new EnterTimeTrack(driver);
		e.getTasks().click();
		TaskList t=new TaskList(driver);
		t.getAddnewbtn().click();
		t.getNewCustomerOption().click();
		FileLib f=new FileLib();
		String expectedcstmname = f.getExcelData("createcustomer", 1, 2);
		t.getCstmtbx().sendKeys(expectedcstmname);
		String cstmdesc = f.getExcelData("createcustomer", 1, 3);
		t.getCstmdesctbx().sendKeys(cstmdesc);
		t.getSelectcstmdropdown().click();
		t.getOurcompanyoption().click();
		t.getCreatecustomerbtn().click();
		Thread.sleep(10000);
		//WebDriverWait wait=new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
		 String actualcstmname = t.getActualcstmname().getText();
		Assert.assertEquals(actualcstmname, expectedcstmname);
	}
	
}
