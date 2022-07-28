package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileOperations {
	/**
	 * With this method, the value stored in the properties file is returned
	 * 
	 * @param filePath
	 * @param key
	 * @return
	 *
	 */
	public static String getConfigValue(String filePath, @SuppressWarnings("rawtypes") Enum key) {
		String value = null;
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(filePath));
			value = prop.getProperty(key.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

}
