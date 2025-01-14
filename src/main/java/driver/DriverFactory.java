package driver;

import config.ConfigProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Contains method to create driver for iOS and Android
 */
public class DriverFactory {
    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);
    private static AppiumDriverLocalService service;
    private static final ThreadLocal<AppiumDriverLocalService> serviceManager = new ThreadLocal<>();
    private static final ThreadLocal<AppiumDriver> driverManager = new ThreadLocal<>();
    static DriverBuilderAndroid driverBuilderAndroid = new DriverBuilderAndroid();
    static DriverBuilderIOS driverBuilderIOS = new DriverBuilderIOS();

    public static AppiumDriverLocalService getAppiumService() {
        return serviceManager.get();
    }

    /**
     * Creates driver
     *
     * @param configProperties ConfigProperties
     * @return AppiumDriver
     */
    public static AppiumDriver createDriver(ConfigProperties configProperties) {
        String platformName = configProperties.getPlatformName();
        logger.info(String.format("Creating %s driver", platformName));

        AppiumServiceBuilder builder = DriverBuilder.createAppiumServiceBuilder(configProperties);
        service = builder.build();
        service.start();

        AppiumDriver driver = platformName.equals("Android")
                ? driverBuilderAndroid.createDriver(builder, configProperties)
                : driverBuilderIOS.createDriver(builder, configProperties);

        serviceManager.set(service);
        driverManager.set(driver);
        return driver;
    }

    /**
     * Gets driver
     *
     * @return AppiumDriver
     */
    public static AppiumDriver getDriver() {
        return driverManager.get();
    }

}
