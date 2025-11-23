package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig 
{
	public Properties prop;
	public FileInputStream file;
	
	public ReadConfig() throws IOException
	{
		prop=new Properties();
		
		file=new FileInputStream("config.properties");
		
		prop.load(file);
		
	}
	
	
	public String getBrowser()
	{
		return prop.getProperty("browser");
	}

}
