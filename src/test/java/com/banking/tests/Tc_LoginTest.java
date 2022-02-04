package com.banking.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.commonlib.commonLib;
import com.banking.genriclib.basetest;
import com.banking.pages.loginpage;

public class Tc_LoginTest extends basetest {

//	@Test(priority=0)
//	public void initialization()
//	{
//		basetest bt = new basetest();
//		bt.setup("chrome");
//	}
	
	@Test(priority = 1)
	public void logintest() throws Throwable {

		log.info("application is opened");
		loginpage lp = new loginpage(driver);
		lp.setun(username);
		log.info("username enterd");
		lp.setpwd(password);
		log.info("password enterd");
		lp.loginbtn();
		log.info("clicked on loginbutton");

	}

	@Test(priority=2)
	public void verifyPagetitle()
	{
		String PT = "Guru99 Bank Manager HomePage";
        Assert.assertEquals(driver.getTitle(), PT);
		
		if(PT.equals(driver.getTitle()))
		{
			log.info("titile is correct");
		}
		else 
		{
		    commonLib cl = new commonLib();
		    cl.getPageScreenShot("title");
		    log.info("titile is wrong");
		}
	}
}
