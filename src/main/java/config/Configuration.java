package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;


@Sources({"system:properties",
		"system:env",
		"file:./src/test/resources/config/config.properties",
		"file:./src/test/resources/config/data.properties"})
@LoadPolicy(LoadType.MERGE)
public interface Configuration extends Config{

    @Key("TARGET")
    String TARGET();
    
    @Key("BROWSER")
    String BROWSER();
    
    @Key("URL")
    String URL();
    
    @Key("REMOTE_URL")
    String REMOTE_URL();
    
    @Key("REMOTE_PORT")
    String REMOTE_PORT();
    
    @Key("EXCEL_DATA_FILE_PATH")
    String EXCEL_DATA_FILE_PATH();
}

