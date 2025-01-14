package driver;

import config.ConfigProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumServiceBuilder;

/**
 * Contains method to create driver for Android
 */
public class DriverBuilderAndroid extends DriverBuilder {

    static DriverCapabilityAndroid driverCapabilityAndroid = new DriverCapabilityAndroid();

    /**
     * Create driver to one thread with service builder
     *
     * @param builder          AppiumServiceBuilder
     * @param configProperties ConfigProperties
     * @return AndroidDriver
     */
    public AppiumDriver createDriver(AppiumServiceBuilder builder, ConfigProperties configProperties) {
        return new AndroidDriver(builder, driverCapabilityAndroid.createDiverCapabilities(configProperties));
    }
}
