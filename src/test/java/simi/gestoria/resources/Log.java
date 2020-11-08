package simi.gestoria.resources;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {
	
	public void logInfo(String nameClass,String step) {
		Logger logger=Logger.getLogger(nameClass);
		PropertyConfigurator.configure("Log4j.properties");
		logger.info(step);	
	}
	
	

}
