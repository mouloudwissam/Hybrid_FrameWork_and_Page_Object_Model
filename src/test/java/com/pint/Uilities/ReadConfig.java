package com.pint.Uilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;

	public ReadConfig() {
		File src = new File("./Configartions/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);// Read file in read mode;
			pro = new Properties();
			pro.load(fis);// load complete file from config.proprties.
		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}
	}

	public String getApplicationUrl() {
		String url = pro.getProperty("baseUrl");
		return url;
	}

	public String getUserName() {
		return pro.getProperty("userName");

	}

	public String getPassWord() {
		return pro.getProperty("passWord");

	}

	public String getChromePath() {
		return pro.getProperty("pathChrome");

	}

	public String getFireFox() {
		return pro.getProperty("pathFirefox");

	}

	public String getOpera() {
		return pro.getProperty("pathopera");
	}

	public String getIE() {
	return pro.getProperty("pathIE");
	
	}
}
