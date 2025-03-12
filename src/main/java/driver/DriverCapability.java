package driver;

import config.ConfigProperties;
import org.openqa.selenium.remote.DesiredCapabilities;

import static enums.AppiumEnum.*;

/**
 * Contains methods to create capabilities needed for Appium
 */
public interface DriverCapability {
    /**
     * Method which creates the desired capabilities for appium service
     *
     * @return Desired capabilities for appium service
     */
    public static DesiredCapabilities createInitCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(APPIUM_NEW_COMMAND_TIMEOUT.getAppiumCapability(), 2000);
        return desiredCapabilities;
    }

    public DesiredCapabilities createDiverCapabilities(ConfigProperties configProperties);
}
