package driver;

import config.ConfigProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static enums.AppiumEnum.*;


/**
 * Contains methods to create service and driver for Appium
 */
public abstract class DriverBuilder {
    public static final Logger logger = LoggerFactory.getLogger(DriverBuilder.class);

    /**
     * Method which creates the desired capabilities for appium service
     *
     * @return AppiumServiceBuilder
     */
    public static AppiumServiceBuilder createAppiumServiceBuilder(ConfigProperties configProperties) {
        AppiumServiceBuilder builder;
        logger.info("Creating appium service using any free port");
        builder = new AppiumServiceBuilder().withCapabilities(DriverCapability.createInitCapabilities())
                .withIPAddress(configProperties.getServiceURL())
                .usingAnyFreePort()
                .withArgument(BASE_PATH::getAppiumCapability, BASE_PATH_VALUE.getAppiumCapability())
                .withArgument(LOG_LEVEL::getAppiumCapability, LOG_LEVEL_VALUE.getAppiumCapability());
        return builder;
    }

    public abstract AppiumDriver createDriver(AppiumServiceBuilder builder, ConfigProperties configProperties);
}
