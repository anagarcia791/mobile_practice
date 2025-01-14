package driver;

import config.ConfigProperties;
import org.openqa.selenium.remote.DesiredCapabilities;

import static enums.AppiumEnum.*;

/**
 * Contains methods to create capabilities for iOS
 */
public class DriverCapabilityIOS extends DriverCapability {

    /**
     * @param configProperties ConfigProperties
     * @return DesiredCapabilities
     */
    public DesiredCapabilities createDiverCapabilities(ConfigProperties configProperties) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(APPIUM_AUTOMATION_NAME.getAppiumCapability(), configProperties.getAutomationName());
        desiredCapabilities.setCapability(APPIUM_PLATFORM_NAME.getAppiumCapability(), configProperties.getPlatformName().toLowerCase());
        desiredCapabilities.setCapability(APPIUM_PLATFORM_VERSION.getAppiumCapability(), configProperties.getPlatformVersion());
        desiredCapabilities.setCapability(APPIUM_DEVICE_NAME.getAppiumCapability(), configProperties.getDeviceName());
        //desiredCapabilities.setCapability(APPIUM_APP_PACKAGE.getAppiumCapability(), configProperties.getAppPackage());
        //desiredCapabilities.setCapability(APPIUM_APP_ACTIVITY.getAppiumCapability(), configProperties.getAppActivity());
        desiredCapabilities.setCapability(APPIUM_AUTO_GRANT_PERMISSIONS.getAppiumCapability(), Boolean.TRUE);
        desiredCapabilities.setCapability(APPIUM_CLEAR_DEVICE_LOGS_ON_START.getAppiumCapability(), true);
        desiredCapabilities.setCapability(APPIUM_NO_RESET.getAppiumCapability(), true);
        desiredCapabilities.setCapability(APPIUM_UDID.getAppiumCapability(), configProperties.getUdid());
        desiredCapabilities.setCapability(APPIUM_WDA_LAUNCH_TIMEOUT.getAppiumCapability(), "240000");
        desiredCapabilities.setCapability(APPIUM_WDA_CONNECTION_TIMEOUT.getAppiumCapability(), "240000");
        desiredCapabilities.setCapability(APPIUM_WDA_STARTUP_RETRY_INTERVAL.getAppiumCapability(), "20000");
        desiredCapabilities.setCapability(APPIUM_AUTO_ACCEPT_ALERTS.getAppiumCapability(), true);
        return desiredCapabilities;
    }
}
