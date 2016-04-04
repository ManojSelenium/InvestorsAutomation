package com.investors.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class InvestorsConfig {

	public static Properties prop;

	static {

		try {
			new InvestorsConfig().loadProperties();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loadProperties() throws FileNotFoundException, IOException {

		prop = new Properties();
		prop.load(new FileInputStream("investors.properties"));

	}

}
