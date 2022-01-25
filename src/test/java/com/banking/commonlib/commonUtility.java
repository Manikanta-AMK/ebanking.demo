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

import com.banking.geniclib.basetest;
import com.google.common.io.Files;

public class commonUtility extends basetest {

	public String getTitle()
	{
		return driver.getTitle();
	}
	
	public void actions(WebElement element)
	{
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	public void robot() throws AWTException
	{
		Robot r = new Robot();
	}
	
	public void staticDropDown(WebElement element)
	{
		Select s = new Select(element);
		
	}
	
	public String getPageScreenShot(String Screenshotname)
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = "C:\\Users\\Dell\\eclipse-workspace\\"
				+ "com.banking.demo\\Screenshots"+ Screenshotname+".png";
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
	
	
	
	
	
	
	
	
}
