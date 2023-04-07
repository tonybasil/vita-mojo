package utils;

import java.util.Properties;

public class PropertyReader {

    Properties prop = new Properties();

    public PropertyReader(String propertiesPath) {
        try {
            prop.load(getClass().getClassLoader().getResourceAsStream(propertiesPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return prop.getProperty(key);
    }

}

