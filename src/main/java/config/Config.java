package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Config {
    protected static final Logger logger = LoggerFactory.getLogger(Config.class);


    private static final Properties properties = new Properties();

    static {
        String env = System.getProperty("env", "dev");
        String fileName = "application-" + env + ".properties";

        logger.info("Loading config for env: {}", env);
        logger.info("Config file: {}", fileName);

        try (InputStream is = Config.class
                .getClassLoader()
                .getResourceAsStream(fileName)) {

            if (is == null) {
                throw new RuntimeException("Config file not found: " + fileName);
            }
            properties.load(is);
            logger.info("Config loaded successfully");

        } catch (IOException e) {
            logger.error("Failed to load config", e);
            throw new RuntimeException(e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
