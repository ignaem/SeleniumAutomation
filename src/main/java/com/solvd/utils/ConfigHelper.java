package com.solvd.utils;

import java.io.IOException;
import java.util.Properties;

public class ConfigHelper {
    private static final String TEST_DATA_PROPERTIES = "testData.properties";
    public static String getValue(String key){
        Properties propAux = new Properties();
        String value;
        try {
            propAux.load(ConfigHelper.class.getClassLoader().getResourceAsStream(TEST_DATA_PROPERTIES));
            value = propAux.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return value;
    }
}
