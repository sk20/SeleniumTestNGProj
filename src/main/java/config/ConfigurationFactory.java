package config;

import org.aeonbits.owner.ConfigCache;



public class ConfigurationFactory {

	public ConfigurationFactory() {
		
	}

	public static Configuration getConfigs() {
        return ConfigCache.getOrCreate(Configuration.class);

    }
	
}
