package steps;


import config.ConfigProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import runner.TestContext;

/**
 * Class to manage initial set up
 */
public class BaseSteps {
    protected static ThreadLocal<TestContext> testContext = new ThreadLocal<>();
    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    private static ThreadLocal<ConfigProperties> configProperties = new ThreadLocal<>();
    protected AppiumDriverLocalService appiumService;

    public BaseSteps(TestContext testContext) {
        this.testContext.set(testContext);
    }

    public static AppiumDriver getDriver() {
        return driver.get();
    }

    public void setDriver(AppiumDriver driver) {
        this.driver.set(driver);
    }

    public ConfigProperties getConfigProperties() {
        return configProperties.get();
    }

    public void setConfigProperties(ConfigProperties configProperties) {
        this.configProperties.set(configProperties);
    }

}
