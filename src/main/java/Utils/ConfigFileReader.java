package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	public static String LoadPropertyFile(String key) throws IOException{
		FileInputStream fis = new FileInputStream("src\\main\\java\\config\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.get(key).toString();
		
	}
	

}
