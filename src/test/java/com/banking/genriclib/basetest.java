package com.banking.genriclib;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basetest {

	readConfig rdc = new readConfig();
	public String url = rdc.geturl();
	public String username = rdc.getusername();
	public String password = rdc.getpassword();
	public WebDriver driver;
	public Logger log;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		log = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("./properties/log4j.properties");
		if(br.equals("chrome"))
		{
		    WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		}else if(br.equals("microsoftedge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else if(br.equals("ie")){
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		log.info("window is mximized");
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		driver.get(url);
		log.info("application is opened");
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
}
