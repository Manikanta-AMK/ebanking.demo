package com.banking.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	@FindBy(xpath="//a[text()=\"Log out\"]") WebElement lgoutbtn;
	
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
	
	public void logoutbtn()
	{
		lgoutbtn.click();
	}
	
	
	
	
}
