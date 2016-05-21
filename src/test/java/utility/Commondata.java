package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Commondata {
	
	Logger log= Logger.getLogger(Commondata.class);

	public String commonValues(String keyname) throws FileNotFoundException {
//		To get the file name
		String propvalue = System.getProperty("config.properties");
		
		FileInputStream fis= new FileInputStream(propvalue);
		
		Properties prop= new Properties();
		try {
			prop.load(fis);
			log.info("Loaded the config file");
		} catch (IOException e) {
			log.info("unable to load the config  file");
			e.printStackTrace();			
		}
		String keyvalue = prop.getProperty(keyname);		
		return keyvalue;
		
	}
}
