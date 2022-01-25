package com.banking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class loginpage {

	public WebDriver ldriver;
	public loginpage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid") WebElement un;
	@FindBy(name="password") WebElement pwd;
	@FindBy(xpath="//input[@type='submit']") WebElement lgBtn;
	
	public void setun(String username)
	{
		un.sendKeys(username);
	}
	
	public void setpwd(String password)
	{
		pwd.sendKeys(password);
	}
	
	public void loginbtn()
	{
		lgBtn.click();
	}
	
	public void pagetitle()
	{
		String PT = "Guru99 Bank Manager HomePage";
		Assert.assertEquals(ldriver.getTitle(), PT);
	}
	
	
	
	
}
