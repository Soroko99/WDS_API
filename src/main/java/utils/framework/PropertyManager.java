package utils.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    public static String apiPathes = "src/test/resources/APIPathes.properties";

    public String getApiPaths(String propertyName){
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(apiPathes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties property = new Properties();
        try {
            property.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property.getProperty(propertyName);
    }
}
