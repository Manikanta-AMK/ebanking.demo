package com.banking.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.commonlib.commonLib;
import com.banking.genriclib.basetest;
import com.banking.pages.loginpage;
import com.banking.xlUtils.excelUtils;

public class TC_InvalidLoginTest extends basetest
{
	@Test(dataProvider = "LoginData")
	public void invalidlogin() throws Throwable
	{
		loginpage lp = new loginpage(driver);
		lp.setun(username);
		log.info("username is enterd");
		lp.setpwd(password);
		log.info("password is provided");
		lp.loginbtn();
		log.info("clicked on login button");
		
		Thread.sleep(2000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			log.info("contorl is switched to alert");
			driver.switchTo().defaultContent();
            log.info("contorl switched to previous page");
			Assert.assertTrue(false);
			log.warn("login failed");
		}
		else 
		{
			Assert.assertFalse(true);
			log.warn("login success");
			commonLib cl = new commonLib();
			cl.getPageScreenShot("invalidlogin");
			log.info("screenshot has taken");
			lp.logoutbtn();
			log.info("clicked on logout button");
			driver.switchTo().alert().accept();
			log.info("contorl is switched to alert");
			driver.switchTo().defaultContent();
			log.info("contorl switched to previous page");
		}
		log.info("invalid login test is completed");
	}
	
	public boolean isAlertPresent()
	{
		try {
		driver.switchTo().alert();
		return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws Throwable
	{
		excelUtils ex = new excelUtils();
		String path = "C:\\Users\\Windows 10\\git\\ebanking.demo\\src\\test\\java\\com\\banking\\xlUtils\\inputdata.xlsx";
		int rowcount = excelUtils.getRowCount(path, "Sheet1");
		int cellcount = excelUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String[rowcount][cellcount];
		
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<cellcount;j++)
			{
				logindata[i-1][j] = excelUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
}
