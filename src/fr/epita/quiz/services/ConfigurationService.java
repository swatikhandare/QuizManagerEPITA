package fr.epita.quiz.services;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author Swati Khandare
 *
 */
public class ConfigurationService {

	private static ConfigurationService instance;
	

	
	
	Properties props = new Properties();
	boolean init = false;
	
	private ConfigurationService() {
		try {
			File confFile = new File("conf.properties");
			FileInputStream ips = new FileInputStream(confFile);
			props.load(ips);
			init =true;
		} catch (Exception e) {
			init=false;
		}

	}

	/**
	 * 
	 * @return
	 */
	public static ConfigurationService getInstance() {
		if (instance == null) {
			instance = new ConfigurationService();
		}
		return instance;
	}
	
	public boolean isInit() {
		return init;
	}



	public String getConfigurationValue(String key, String defaultValue) {
		return props.getProperty(key, defaultValue);
	}
	public String getConfigurationValue(ConfigEntry key, String defaultValue) {
		return props.getProperty(key.getKey(), defaultValue);
	}

}
