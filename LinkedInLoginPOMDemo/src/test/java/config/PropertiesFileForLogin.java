package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileForLogin {

	static Properties prop= new Properties();
	static String projectPath = System.getProperty("user.dir");
	
	
	public static void getProperties() throws IOException {
		
		InputStream input = new FileInputStream (projectPath+"\\src\\test\\java\\config\\UID&PassConfig.Properties");
		prop.load(input);
			
	}

	public static String getCredentials(String Data) throws IOException {
		getProperties();
		String data= prop.getProperty(Data);
		return data;
	}
}
