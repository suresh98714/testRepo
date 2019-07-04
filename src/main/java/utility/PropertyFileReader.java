package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	
	public static Properties getproperty() throws FileNotFoundException, IOException{
		FileInputStream fio=null;
		Properties prop=new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config/config.properties"));
		return prop;
	}

	
		
}
