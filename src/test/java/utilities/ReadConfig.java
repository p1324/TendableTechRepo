package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	String path = "C:\\Users\\HP\\automation workplace\\TendableTechChallenge\\Configuration\\Config.properties";

	public ReadConfig() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public String getBaseURL() {
		String value = prop.getProperty("BaseURL");

		if (value != null)
			return value;
		else
			throw new RuntimeException("url not specified in config file.");

	}

	public String getBrowser() {
		String value = prop.getProperty("Browser");

		if (value != null)
			return value;
		else
			throw new RuntimeException("Browser not specified in config file.");

	}

}
