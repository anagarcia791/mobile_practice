package config;

import java.util.stream.IntStream;

/**
 * Contains methods to set and get current properties
 */
public class SetFileProperty {
    private static ThreadLocal<ConfigProperties> configProperties = new ThreadLocal<>();

    /**
     * This method gets the property file follow the thread
     *
     * @return ConfigProperties
     */
    public static ConfigProperties getConfigProperties() {
        if (null == configProperties.get()) {
            setConfigProperties();
        }
        return configProperties.get();
    }

    /**
     * This method distributes the property file follow the thread
     */
    public static void setConfigProperties() {
        String[] properties = System.getProperty("property").trim().split(",");
        IntStream streamRange = IntStream.range(0, properties.length);
        String property = properties[streamRange.filter(i -> Thread.currentThread().getName().contains(Integer.toString(i))).findFirst().orElse(0)];
        configProperties.set(new ConfigProperties(property));
    }
}
