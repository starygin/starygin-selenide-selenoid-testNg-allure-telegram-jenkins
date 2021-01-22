package utils;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class ConfigureProperties {

    private static final Properties CONFIGURE_PROPERTIES;

    private ConfigureProperties() {
    }

    static {
        CONFIGURE_PROPERTIES = new Properties();
        URL Url = ClassLoader.getSystemResource("configure.properties");

        try {
            CONFIGURE_PROPERTIES.load(Url.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getConfigureProperty(String key) {
        return CONFIGURE_PROPERTIES.getProperty(key);
    }


}