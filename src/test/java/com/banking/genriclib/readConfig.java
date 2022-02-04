package com.banking.genriclib;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfig 
{

	Properties prop;
	public readConfig() 
	{
		File src = new File("./properties/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
            System.out.println("exception is " + e.getMessage());
		}
	}
	
	public String geturl()
	{
		String appurl = prop.getProperty("url");
		return appurl;
	}
	
	public String getusername()
	{
		String un = prop.getProperty("username");
		return un;
	}
	
	public String getpassword()
	{
		String pwd = prop.getProperty("password");
		return pwd;
	}

}
