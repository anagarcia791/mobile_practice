package driver;

import config.ConfigProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumServiceBuilder;

/**
 * Contains method to create driver for iOS
 */
public class DriverBuilderIOS extends DriverBuilder {

    static DriverCapabilityIOS driverCapabilityIOS = new DriverCapabilityIOS();

    /**
     * Create driver to one thread with service builder
     *
     * @param builder          AppiumServiceBuilder
     * @param configProperties ConfigProperties
     * @return IOSDriver
     */
    public AppiumDriver createDriver(AppiumServiceBuilder builder, ConfigProperties configProperties) {
        return new IOSDriver(builder, driverCapabilityIOS.createDiverCapabilities(configProperties));
    }
}