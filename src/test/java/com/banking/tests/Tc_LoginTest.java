package com.banking.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.geniclib.basetest;
import com.banking.pages.loginpage;

public class Tc_LoginTest extends basetest {

	@Test
	public void logintest() throws Throwable
	{
		
		log.info("application is opened");
		loginpage lp = new loginpage(driver);
		lp.setun(username);
		log.info("username enterd");
		lp.setpwd(password);
        log.info("password enterd");
		lp.loginbtn();
		log.info("clicked on loginbutton");
		lp.pagetitle();
	}
}
