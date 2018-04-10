package service.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class AppProperties {

    private final Properties properties = new Properties();

    private AppProperties() {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream("app.properties");

        try {
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getProperty(final String key) {
        return properties.getProperty(key);
    }

    public static AppProperties getInstance() {
        return Helper.INSTANCE;
    }

    private static class Helper {
        private static final AppProperties INSTANCE = new AppProperties();
    }
}
