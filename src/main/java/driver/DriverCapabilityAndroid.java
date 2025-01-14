package driver;

import config.ConfigProperties;
import org.openqa.selenium.remote.DesiredCapabilities;

import static enums.AppiumEnum.*;
import static enums.AppiumEnum.APPIUM_CLEAR_DEVICE_LOGS_ON_START;

/**
 * Contains methods to create capabilities for Android
 */
public class DriverCapabilityAndroid extends DriverCapability {

    /**
     * @param configProperties ConfigProperties
     * @return DesiredCapabilities
     */
    public DesiredCapabilities createDiverCapabilities(ConfigProperties configProperties) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(APPIUM_AUTOMATION_NAME.getAppiumCapability(), configProperties.getAutomationName());
        desiredCapabilities.setCapability(APPIUM_PLATFORM_NAME.getAppiumCapability(), configProperties.getPlatformName());
        desiredCapabilities.setCapability(APPIUM_PLATFORM_VERSION.getAppiumCapability(), configProperties.getPlatformVersion());
        desiredCapabilities.setCapability(APPIUM_DEVICE_NAME.getAppiumCapability(), configProperties.getDeviceName());
        //desiredCapabilities.setCapability(APPIUM_APP_PACKAGE.getAppiumCapability(), configProperties.getAppPackage());
        //desiredCapabilities.setCapability(APPIUM_APP_ACTIVITY.getAppiumCapability(), configProperties.getAppActivity());
        desiredCapabilities.setCapability(APPIUM_AUTO_GRANT_PERMISSIONS.getAppiumCapability(), Boolean.TRUE);
        desiredCapabilities.setCapability(APPIUM_CLEAR_DEVICE_LOGS_ON_START.getAppiumCapability(), true);
        desiredCapabilities.setCapability(APPIUM_NO_RESET.getAppiumCapability(), true);
        return desiredCapabilities;
    }
}
