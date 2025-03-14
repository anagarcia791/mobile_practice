package enums;

/**
 * Contains the capabilities to create a session of the diver
 **/
public enum AppiumEnum {
    BASE_PATH("--base-path"),
    BASE_PATH_VALUE("/wd/hub"),
    LOG_LEVEL("--log-level"),
    LOG_LEVEL_VALUE("error:warn"),
    APPIUM_NEW_COMMAND_TIMEOUT("appium:newCommandTimeout"),
    APPIUM_AUTOMATION_NAME("appium:automationName"),
    APPIUM_PLATFORM_NAME("appium:platformName"),
    APPIUM_PLATFORM_VERSION("appium:platformVersion"),
    APPIUM_DEVICE_NAME("appium:deviceName"),
    APPIUM_APP_PACKAGE("appium:appPackage"),
    APPIUM_APP_ACTIVITY("appium:appActivity"),
    APPIUM_AUTO_GRANT_PERMISSIONS("appium:autoGrantPermissions"),
    APPIUM_CLEAR_DEVICE_LOGS_ON_START("appium:clearDeviceLogsOnStart"),
    APPIUM_NO_RESET("appium:noReset"),
    APPIUM_UDID("appium:udid"),
    APPIUM_WDA_LAUNCH_TIMEOUT("appium:wdaLaunchTimeout"),
    APPIUM_WDA_CONNECTION_TIMEOUT("appium:wdaConnectionTimeout"),
    APPIUM_WDA_STARTUP_RETRY_INTERVAL("appium:wdaStartupRetryInterval"),
    APPIUM_AUTO_ACCEPT_ALERTS("appium:autoAcceptAlerts");

    AppiumEnum(String appiumCapability) {
        this.appiumCapability = appiumCapability;
    }

    private final String appiumCapability;

    public String getAppiumCapability() {
        return appiumCapability;
    }
}
