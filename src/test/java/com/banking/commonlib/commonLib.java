package com.banking.commonlib;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.banking.genriclib.basetest;
import com.google.common.io.Files;

public class commonLib extends basetest {

	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public void verifyTitle(String actual, String expected, String pageTitle)
	{
		Assert.assertEquals(actual, expected);
		Reporter.log(pageTitle+" title is displayed ", true);
	}
	
	public void mouseHoverActions(WebElement element)
	{
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	public void robot() throws AWTException
	{
		Robot r = new Robot();
		
	}
	
	public void staticDropDown(WebElement element, int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	public void staticDropDown(WebElement element, String value)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	public void staticDropDown(String text, WebElement element )
	{
		Select s =new Select(element);
		s.selectByVisibleText(text);
	}
	
	public String getPageScreenShot(String Screenshotname)
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = "C:\\Users\\Windows 10\\git\\ebanking.demo"+ Screenshotname+".png";
		File dest = new File(path);
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	public String getElementScreenShot(WebElement element, String screenshotname)
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = element.getScreenshotAs(OutputType.FILE);
        String path = "C:\\Users\\Dell\\eclipse-workspace\\com.banking."
        		+ "demo\\Screenshots "+screenshotname+".png";
        File dest = new File(path);
        try {
			Files.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
        return path;
	}
	
	public void frame(int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void frame(WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void frame(String index)
	{
		driver.switchTo().frame(index);
	}
	
	
	
	
	
	
	
	
}
