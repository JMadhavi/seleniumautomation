package demo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static java.lang.System.getProperty;

public class Utils {
    private static final Properties prop = new Properties();


    public static String getPropertyValue(String propertyName) {
        File file = new File(getProperty("user.dir")+"/src/test/resources/"+getProperty("prpfile", "test.properties"));
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


//load test.properties file
        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
//get property value
        return prop.getProperty(propertyName);
    }


}
